package ru.spbu.arts.java.oop.rational;

public class ExperimentsWithRational {
    public static void main(String[] args) {
        var r1 = new Rational(6, -4);
        var r2 = new Rational(5);
        var r3 = new Rational(-8, -4);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println();

        System.out.println(r1.toDouble());
        System.out.println(r2.toDouble());
        System.out.println(r3.toDouble());
        System.out.println();

        var r4 = new Rational(1, 6);
        var r5 = new Rational(-1, 3);
        Rational r6 = r4.add(r5);
        System.out.println(r6.toString());
        r4.addInPlace(r5);
        System.out.println(r4);
        System.out.println();
    }
}
