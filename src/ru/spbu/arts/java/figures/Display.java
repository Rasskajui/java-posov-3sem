package ru.spbu.arts.java.figures;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Display {
    private double x0;
    private double y0;
    private double d;

    public Display(double x0, double y0, double d){
        this.x0 = x0;
        this.y0 = y0;
        this.d = d;
    }

    public void paint(WritableImage image, Fractal fractal){
        double w = image.getWidth();
        double h = image.getHeight();
        PixelWriter pixelWriter = image.getPixelWriter();

        for (int xPixel = 0; xPixel < w; xPixel++)
            for (int yPixel = 0; yPixel < h; yPixel++){
                double x = x0 + d * xPixel;
                double y = y0 - d * yPixel;
                double c = fractal.paint(x, y);
                Color color = GrayscalePalette.getColor(c);

                pixelWriter.setColor(xPixel, yPixel, color);
            }
    }
}
