package ru.spbu.arts.java.figures;

public class CircleFractal implements Fractal {
    @Override
    public double paint(double x, double y) {
        if (x * x + y * y <= 1)
            return x * x + y * y;
        else
            return 1;
    }
}
