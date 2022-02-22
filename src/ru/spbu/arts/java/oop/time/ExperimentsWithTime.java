package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {
    public static void main(String[] args) {
        Time t = new Time(9, 10);
        Time t1 = new Time(13, 54);
        Time t2 = new Time(243, 123);
        System.out.println(t.show());
        System.out.println(t1.isDay());

        System.out.println(t.sayHello());
        System.out.println(t1.sayHello());
        System.out.println(t2.sayHello());

        t.add(20);
        System.out.println(t.show());

        t1.add(123);
        System.out.println(t1.show());

        t2.add(123);
        System.out.println(t2.show());
    }


}
