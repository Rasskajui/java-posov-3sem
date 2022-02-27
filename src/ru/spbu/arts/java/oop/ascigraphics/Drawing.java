package ru.spbu.arts.java.oop.ascigraphics;

public class Drawing {
    private char[][] drawing;

    public Drawing(int x, int y, char c){
        char[][] drawMassive = new char[y][x];
        for (int i = 0; i < y; i++){
            for (int j = 0; j < x; j++){
                drawMassive[i][j] = c;
            }
        }
        this.drawing = drawMassive;
    }

    public void print(){
        for (char[] x : this.drawing){
            for (char s : x){
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public void setPoint(int x, int y, char c){
        this.drawing[this.drawing.length - y][x - 1] = c;
    }

    public void drawVerticalLine(int x, int y1, int y2, char c){
        for (int y = y1; y <= y2; y++){
            this.setPoint(x, y, c);
        }
    }

    public void drawHorizontalLine(int x1, int x2, int y, char c){
        for (int x = x1; x <= x2; x++){
            this.setPoint(x, y, c);
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char c){
        this.drawHorizontalLine(x1, x2, y1, c);
        this.drawHorizontalLine(x1, x2, y2, c);
        this.drawVerticalLine(x1, y1, y2, c);
        this.drawVerticalLine(x2, y1, y2, c);
    }

    public void drawCircle(int xc, int yc, int r, char c){
        for (int x = 0; x < this.drawing.length; x++){
            for (int y = 0; y < this.drawing[x].length; y++){
                if (Math.pow(x - xc, 2) + Math.pow(y - yc, 2) <= Math.pow(r, 2)){
                    setPoint(x, y, c);
                }
            }
        }
    }

    public void draw(int x, int y, Drawing d){
        for (int yr = y; yr > y - d.drawing.length; yr--){
            for (int xr = x; xr < x + d.drawing[0].length; xr++){
                setPoint(xr, yr, d.drawing[y - yr][xr - x]);
            }
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2, char c) {
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
            setPoint(x, y, c);
            error += deltaErr;
            if (error > 1.0){
                y += dirY;
                error -= 1.0;
            }
        }

    }
}
