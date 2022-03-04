package ru.spbu.arts.java.oop.rational;

public class Rational {
    private int n;
    private int d;

    public Rational(int n, int d){

        int a = n;
        int b = d;

        while(b != 0){
            int mod = a % b;
            a = b;
            b = mod;
        }

        n = n / a;
        d = d / a;

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

        int gcd = r.d;
        int b = this.d;

        while(b != 0){
            int mod = gcd % b;
            gcd = b;
            b = mod;
        }

        int lcm = r.d * this.d / gcd;
        int newNum = (lcm / this.d)* this.n + (lcm / r.d) * r.n;

        return new Rational(newNum, lcm);
    }

    public void addInPlace(Rational r){
        var newRat = this.add(r);
        this.n = newRat.n;
        this.d = newRat.d;
    }

    public Rational sub(Rational r){
        var toSub = new Rational(- r.n, r.d);
        return this.add(toSub);
    }

    public void subInPlace(Rational r){
        var newRat = this.sub(r);
        this.n = newRat.n;
        this.d = newRat.d;
    }

    public Rational mul(Rational r){
        return new Rational(this.n * r.n, this.d * r.d);
    }

    public void mulInPlace(Rational r){
        var newNum = new Rational(this.n * r.n, this.d * r.d);
        this.n = newNum.n;
        this.d = newNum.d;
    }

    public Rational div(Rational r){
        var toDiv = new Rational(r.d, r.n);
        return this.mul(toDiv);
    }

    public void divInPlace(Rational r){
        var newNum = new Rational(this.n * r.d, this.d * r.n);
        this.n = newNum.n;
        this.d = newNum.d;
    }



}
