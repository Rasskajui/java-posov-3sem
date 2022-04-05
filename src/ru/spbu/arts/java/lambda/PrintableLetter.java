package ru.spbu.arts.java.lambda;

public class PrintableLetter implements Printable {
    String s;
    int n;

    public PrintableLetter(String s, int n){
        this.s = s;
        this.n = n;
    }

    public void print(){
        System.out.println(s.repeat(n));
    }
}
