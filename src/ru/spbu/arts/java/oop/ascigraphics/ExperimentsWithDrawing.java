package ru.spbu.arts.java.oop.ascigraphics;

public class ExperimentsWithDrawing {
    public static void main(String[] args) {
        var d1 = new Drawing(5, 4, '.');
        var d2 = new Drawing(7, 7, '.');
        d1.setPoint(2, 3, '/');
        d1.print();
        System.out.println();

        d2.drawVerticalLine(2, 3, 5, '+');
        d2.print();
        System.out.println();

        d2.drawHorizontalLine(1, 6, 4, '-');
        d2.print();
        System.out.println();

        d2.drawRectangle(3, 3, 5, 5, 'c');
        d2.print();
    }
}
