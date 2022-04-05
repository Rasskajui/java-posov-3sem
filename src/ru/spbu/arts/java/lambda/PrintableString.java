package ru.spbu.arts.java.lambda;

public class PrintableString implements Printable{
    String s;

    PrintableString(String s){
        this.s = s;
    }

    public void print(){
        System.out.println(s);
    }
}
