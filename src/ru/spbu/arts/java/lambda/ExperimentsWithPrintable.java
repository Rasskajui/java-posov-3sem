package ru.spbu.arts.java.lambda;
import ru.spbu.arts.java.oop.ascigraphics.Drawing;

public class ExperimentsWithPrintable {
    public static void main(String[] args) {
        Printable p1 = new Drawing(3, 3, '0');
        p1.print();

        PrintableLetter pl = new PrintableLetter("x", 10);
        pl.print(); //печатает букву x 10 раз

        PrintableString ps = new PrintableString("asdf");
        ps.print(); //печатает asdf

        Printable lambda = () -> System.out.println("I'm feeling good");

        Printable anon = new Printable() {
            @Override
            public void print() {
                System.out.println("I'm feeling nice");
            }
        };

        Printable[] elements = {p1, pl, ps, lambda, anon};
        for (Printable element : elements)
            element.print();
    }
}

