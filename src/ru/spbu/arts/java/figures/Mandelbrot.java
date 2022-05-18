package ru.spbu.arts.java.figures;

public class Mandelbrot implements Fractal{
    public double paint(double x, double y){
        double zx = 0;
        double zy = 0;
        for (int step = 0; step < 1000; step++){
            double zxTemp = zx;
            zx = zx * zx - zy * zy + x;
            zy = 2 * zxTemp * zy + y;

            if (Math.sqrt(zx * zx + zy * zy) > 1000000000)
                return step/1000.0;
        }
        return 0.5;
    }
}
