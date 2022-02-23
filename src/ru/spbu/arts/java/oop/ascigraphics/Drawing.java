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


}
