package ru.spbu.arts.java.oop.ascigraphics;

public class ImmutableDrawing {
    private char[][] imDrawing;

    public ImmutableDrawing(int x, int y, char c){
        char[][] drawMassive = new char[y][x];
        for (int i = 0; i < y; i++){
            for (int j = 0; j < x; j++){
                drawMassive[i][j] = c;
            }
        }
        this.imDrawing = drawMassive;
    }

    public void print(){
        for (char[] x : this.imDrawing){
            for (char s : x){
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public ImmutableDrawing setPoint(int x, int y, char c){
        ImmutableDrawing newDrawing = new ImmutableDrawing(this.imDrawing[0].length, this.imDrawing.length, this.imDrawing[0][0]);
        newDrawing.imDrawing[this.imDrawing.length - y][x - 1] = c;
        return newDrawing;
    }

    public ImmutableDrawing drawVerticalLine(int x, int y1, int y2, char c){
        ImmutableDrawing newDrawing = new ImmutableDrawing(this.imDrawing[0].length, this.imDrawing.length, this.imDrawing[0][0]);
        for (int y = y1; y <= y2; y++){
            newDrawing.imDrawing[this.imDrawing.length - y][x - 1] = c;
        }
        return newDrawing;
    }

    public ImmutableDrawing drawHorizontalLine(int x1, int x2, int y, char c){
        ImmutableDrawing newDrawing = new ImmutableDrawing(this.imDrawing[0].length, this.imDrawing.length, this.imDrawing[0][0]);
        for (int x = x1; x <= x2; x++){
            newDrawing.imDrawing[this.imDrawing.length - y][x - 1] = c;
        }
        return newDrawing;
    }

    public ImmutableDrawing drawRectangle(int x1, int y1, int x2, int y2, char c){
        ImmutableDrawing newDrawing = new ImmutableDrawing(this.imDrawing[0].length, this.imDrawing.length, this.imDrawing[0][0]);
        for (int x = x1; x <= x2; x++){
            newDrawing.imDrawing[this.imDrawing.length - y1][x - 1] = c;
        }
        for (int x = x1; x <= x2; x++){
            newDrawing.imDrawing[this.imDrawing.length - y2][x - 1] = c;
        }
        for (int y = y1; y <= y2; y++){
            newDrawing.imDrawing[this.imDrawing.length - y][x1 - 1] = c;
        }
        for (int y = y1; y <= y2; y++){
            newDrawing.imDrawing[this.imDrawing.length - y][x2 - 1] = c;
        }
        return newDrawing;
    }

    public ImmutableDrawing drawCircle(int xc, int yc, int r, char c){
        ImmutableDrawing newDrawing = new ImmutableDrawing(this.imDrawing[0].length, this.imDrawing.length, this.imDrawing[0][0]);
        for (int x = 0; x < newDrawing.imDrawing.length; x++){
            for (int y = 0; y < newDrawing.imDrawing[x].length; y++){
                if (Math.pow(x - xc, 2) + Math.pow(y - yc, 2) <= Math.pow(r, 2)){
                    newDrawing.imDrawing[newDrawing.imDrawing.length - y][x - 1] = c;
                }
            }
        }
        return newDrawing;
    }

    public ImmutableDrawing draw(int x, int y, ImmutableDrawing d){
        ImmutableDrawing newDrawing = new ImmutableDrawing(this.imDrawing[0].length, this.imDrawing.length, this.imDrawing[0][0]);
        for (int yr = y; yr > y - d.imDrawing.length; yr--){
            for (int xr = x; xr < x + d.imDrawing[0].length; xr++){
                newDrawing.imDrawing[newDrawing.imDrawing.length - yr][xr - 1] = d.imDrawing[y - yr][xr - x];
            }
        }
        return newDrawing;
    }

    public ImmutableDrawing drawLine(int x1, int y1, int x2, int y2, char c) {
        ImmutableDrawing newDrawing = new ImmutableDrawing(this.imDrawing[0].length, this.imDrawing.length, this.imDrawing[0][0]);
        int deltaX = Math.abs(x2 - x1);
        int deltaY = Math.abs(y2 - y1);
        float error = 0;
        float deltaErr = (float) (deltaY + 1) / (float) (deltaX + 1);
        int y = y1;
        int dirY = y2 - y1;
        if (dirY > 0){
            dirY = 1;
        } else if (dirY < 0) {
            dirY = -1;
        }
        for (int x = x1; x < x2; x++){
            newDrawing.imDrawing[newDrawing.imDrawing.length - y][x - 1] = c;
            error += deltaErr;
            if (error > 1.0){
                y += dirY;
                error -= 1.0;
            }
        }
        return newDrawing;
    }
}
