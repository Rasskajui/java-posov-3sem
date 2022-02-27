package ru.spbu.arts.java.oop.ascigraphics;

public class ExperimentsWithDrawing {
    public static void main(String[] args) {
        var d1 = new Drawing(6, 6, 'c');
        var d2 = new Drawing(10, 10, '.');
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

        d2.drawCircle(5, 5, 3, ',');
        d2.print();

        d2.draw(5, 5, d1);
        d2.print();

//        Начало домика

        var house = new Drawing(20, 12, '.');
        house.drawRectangle(5, 2, 15, 6, 'c');
        house.drawCircle(10, 4, 1, '0');
        house.drawLine(3, 6, 11, 9, '/');
        house.drawLine(11, 9, 17, 5, '\\');

        house.print();

    }
}
