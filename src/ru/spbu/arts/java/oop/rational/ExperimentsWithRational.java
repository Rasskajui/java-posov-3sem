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
        var r5 = new Rational(1, 3);
        Rational r6 = r4.add(r5);
        System.out.println(r6.toString());
        r4.addInPlace(r5);
        System.out.println(r4); // 1/2
        System.out.println();

        Rational r7 = r4.sub(r5); // 1/2 - 1/3 = 1/6
        System.out.println(r7.toString());
        r7.subInPlace(r4);
        System.out.println(r7); // 1/6 - 1/2 = -1/3
        System.out.println();

        Rational r8 = r2.mul(r3);
        System.out.println(r8); // 5 * 2 = 10
        r8.mulInPlace(r1);
        System.out.println(r8); // 10 * -3/2 = -15
        System.out.println();

        Rational r9 = r8.div(r1);
        System.out.println(r9); // -15 / -3/2 = 10
        r9.divInPlace(r1);
        System.out.println(r9); // 10 / -3/2 = -20/3
        System.out.println();


    }
}
