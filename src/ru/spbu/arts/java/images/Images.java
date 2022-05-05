package ru.spbu.arts.java.images;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Images extends Application {
    @Override
    public void start(Stage stage){
        stage.setTitle("Изображение");

        Parent parent = initInterface();

        stage.setScene(new Scene(parent));
        stage.show();
    }

    private Parent initInterface() {
        WritableImage painting1 = new WritableImage(100, 100);
        PixelWriter pixelWriter1 = painting1.getPixelWriter();
        for (int x = 0; x < 100; x++)
            for(int y = 0; y < 100; y++)
                pixelWriter1.setColor(x, y, Color.WHITE);
        ImageView viewer1 = new ImageView(painting1);

       WritableImage painting2 = new WritableImage(256, 256);
       PixelWriter pixelWriter2 = painting2.getPixelWriter();
       for (int x = 0; x < 256; x++)
           for(int y = 0; y < 256; y++)
               pixelWriter2.setColor(x, y, Color.rgb(x, y, 123));
       ImageView viewer2 = new ImageView(painting2);

       WritableImage painting3 = new WritableImage(360, 100);
       PixelWriter pixelWriter3 = painting3.getPixelWriter();
       for(int x = 0; x < 360; x++)
           for(int y = 0; y < 100; y++)
               pixelWriter3.setColor(x, y, Color.hsb( x, (double) y/100, 0.5));
       ImageView viewer3 = new ImageView(painting3);

        WritableImage painting4 = new WritableImage(100, 100);
        PixelWriter pixelWriter4 = painting4.getPixelWriter();
        for(int x = 0; x < 100; x++)
            for(int y = 0; y < 100; y++) {
                if (x <= 75 & x >= 25 & y <= 75 & y >= 25){
                    pixelWriter4.setColor(x, y, Color.BLACK);
                } else
                    pixelWriter4.setColor(x, y, Color.WHITE);
            }
        ImageView viewer4 = new ImageView(painting4);

        WritableImage painting5 = new WritableImage(100, 100);
        PixelWriter pixelWriter5 = painting5.getPixelWriter();
        for(int x = 0; x < 100; x++)
            for(int y = 0; y < 100; y++){
                if ((x - 50)*(x - 50) + (y - 50)*(y - 50) <= 2500){
                    pixelWriter5.setColor(x, y, Color.BLACK);
                } else
                    pixelWriter5.setColor(x, y, Color.WHITE);
            }
        ImageView viewer5 = new ImageView(painting5);

        WritableImage painting6 = new WritableImage(360, 100);
        PixelWriter pixelWriter6 = painting6.getPixelWriter();
        for(int x = 0; x < 360; x++)
            for(int y = 0; y < 100; y++){
                pixelWriter6.setColor(x, y, LCH.colorFromLCH(y, 50, x));
            }
        ImageView viewer6 = new ImageView(painting6);

        WritableImage painting7 = new WritableImage(371, 100);
        PixelWriter pixelWriter7 = painting7.getPixelWriter();
        for(int x = 380; x < 751; x++)
            for(int y = 0; y < 100; y++){
                pixelWriter7.setColor(x - 380, y, waveLengthToRGB((float) x));
            }
        ImageView viewer7 = new ImageView(painting7);


        FlowPane panel = new FlowPane(viewer1, viewer2, viewer3, viewer4, viewer5, viewer6, viewer7);
        panel.setStyle("-fx-background-color: blue"); // чтобы было видно любимый цвет
        return panel;
    }

    private Color waveLengthToRGB(float wavelength){
        double gamma = 0.8;
        double R = 0;
        double G = 0;
        double B = 0;

        if (wavelength >= 380 & wavelength <= 440) {
            double attenuation = 0.3 + 0.7 * (wavelength - 380) / (440 - 380);
            R = Math.pow((-(wavelength - 440) / (440 - 380)) * attenuation, gamma);
            G = 0.0;
            B = Math.pow(attenuation, gamma);
        } else if (wavelength >= 440 & wavelength <= 490) {
            R = 0.0;
            G = Math.pow((wavelength - 440) / (490 - 440), gamma);
            B = 1.0;
        } else if (wavelength >= 490 & wavelength <= 510) {
            R = 0.0;
            G = 1.0;
            B = Math.pow(-(wavelength - 510) / (510 - 490), gamma);
        } else if (wavelength >= 510 & wavelength <= 580) {
            R = Math.pow((wavelength - 510) / (580 - 510), gamma);
            G = 1.0;
            B = 0.0;
        } else if (wavelength >= 580 & wavelength <= 645) {
            R = 1.0;
            G = Math.pow(-(wavelength - 645) / (645 - 580), gamma);
            B = 0.0;
        } else if (wavelength >= 645 & wavelength <= 750) {
            double attenuation = 0.3 + 0.7 * (750 - wavelength) / (750 - 645);
            R = Math.pow(attenuation, gamma);
            G = 0.0;
            B = 0.0;
        }

        return Color.rgb((int) (R * 255), (int) (G * 255), (int) (B * 255));
    }
}
