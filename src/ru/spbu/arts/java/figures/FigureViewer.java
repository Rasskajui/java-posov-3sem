package ru.spbu.arts.java.figures;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FigureViewer extends Application {
    public final static int W = 600;
    public final static int H = 500;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Фракталы");
        Parent parent = initInterface();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private Parent initInterface() {
        WritableImage img = new WritableImage(W, H);
        Display display = new Display(-4, 5, 8/600.0);
        Fractal mandelbrot = new Mandelbrot();
        display.paint(img, mandelbrot);

        ImageView imageView = new ImageView(img);
        return new Pane(imageView);
    }
}
