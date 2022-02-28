package ru.spbu.arts.java.oop.ascigraphics;

public class ExperimentsWithDrawing {
    public static void main(String[] args) {
        var d1 = new Drawing(6, 6, 'c');
        var d2 = new Drawing(20, 20, '.');
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

        d2.draw(1, 8, d1);
        d2.print();

//        Начало домика

        var house = new Drawing(20, 12, '.');
        house.drawRectangle(5, 2, 15, 6, 'c');
        house.drawCircle(10, 4, 1, '0');
        house.drawLine(3, 6, 11, 9, '/');
        house.drawLine(11, 9, 17, 5, '\\');

        house.print();

//        Конец домика

        var d3 = new ImmutableDrawing(6, 6, '.');

        ImmutableDrawing d4 = d3.setPoint(2, 2, ',');
        d4.print();
        System.out.println();
        d3.print();


        ImmutableDrawing d5 = d3.drawVerticalLine(2, 2, 4, '|');
        d5.print();
        System.out.println();
        d3.print();

        ImmutableDrawing d6 = d3.drawHorizontalLine(1, 3, 3, '-');
        d6.print();
        System.out.println();
        d3.print();

        ImmutableDrawing d7 = d3.drawRectangle(1, 2, 3, 4, '`');
        d7.print();
        System.out.println();
        d3.print();

        ImmutableDrawing d8 = d3.drawCircle(3, 3, 2, 'c');
        d8.print();
        System.out.println();
        d3.print();

        ImmutableDrawing d10 = new ImmutableDrawing(3, 3, 'X');
        ImmutableDrawing d9 = d3.draw(1, 5, d10);
        d9.print();
        System.out.println();
        d3.print();

        ImmutableDrawing d11 = d3.drawLine(1,1, 6, 6, '/');
        d11.print();
        System.out.println();
        d3.print();



    }
}
