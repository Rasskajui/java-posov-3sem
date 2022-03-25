package ru.spbu.arts.java.oop.rational;

public class Rational {
    public static Rational ONE = new Rational(1);
    public static Rational ZERO = new Rational(0);

    static int gcd(int a, int b){
        while(b != 0){
            int mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }

    private int n;
    private int d;

    public Rational(int n, int d){

        int gcd = gcd(n, d);

        n = n / gcd;
        d = d / gcd;

        if (d < 0){
            n = -1 * n;
            d = -1 * d;
        }

        this.n = n;
        this.d = d;

    }

    public Rational(int n){
        this.n = n;
        this.d = 1;
    }

    public String toString(){
        if (this.d == 1){
            return Integer.toString(this.n);
        } else if (this.n == 0){
            return "0";
        }
        return this.n + "/" + this.d;
    }

    public double toDouble(){
        if (this.d != 0) {
            return (double) this.n / this.d;
        }
        return this.n; // не знаю, как вывести ошибку тут :(
    }

    public Rational add(Rational r){
//        int gcd = gcd(r.d, this.d);
//        int lcm = r.d * this.d / gcd;
//        int newNum = (lcm / this.d)* this.n + (lcm / r.d) * r.n;
//        return new Rational(newNum, lcm);
        return new Rational(r.d * this.n + this.d * r.n, r.d * this.d);
    }

    static Rational addStatic(Rational r1, Rational r2){
        return r1.add(r2);
    }

//    public void add(Rational r){
//        var newRat = this.add(r);
//        this.n = newRat.n;
//        this.d = newRat.d;
//    }

    public Rational sub(Rational r){
        var toSub = new Rational(- r.n, r.d);
        return this.add(toSub);
    }

    static Rational subStatic(Rational r1, Rational r2){
        return r1.sub(r2);
    }

//    public void sub(Rational r){
//        var newRat = this.sub(r);
//        this.n = newRat.n;
//        this.d = newRat.d;
//    }

    public Rational mul(Rational r){
        return new Rational(this.n * r.n, this.d * r.d);
    }

    static Rational mulStatic(Rational r1, Rational r2){
        return r1.mul(r2);
    }

//    public void mul(Rational r){
//        var newNum = new Rational(this.n * r.n, this.d * r.d);
//        this.n = newNum.n;
//        this.d = newNum.d;
//    }

    public Rational div(Rational r){
        var toDiv = new Rational(r.d, r.n);
        return this.mul(toDiv);
    }

    static Rational divStatic(Rational r1, Rational r2){
        return r1.div(r2);
    }

//    public void div(Rational r){
//        var newNum = new Rational(this.n * r.d, this.d * r.n);
//        this.n = newNum.n;
//        this.d = newNum.d;
//    }

    public int getN(){
        return this.n;
    }

    public int getD(){
        return this.d;
    }

}
