package ru.spbu.arts.java.figures;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class FigureViewer extends Application {
    public final static int W = 600;
    public final static int H = 500;

    private double x0 = -4.5;
    private double y0 = 3.75;
    private double d = 8/600.0;

    private Display display;
    private Mandelbrot mandelbrot;
    private WritableImage img;

    private Button left;
    private Button right;
    private Button up;
    private Button down;

    private Button further;
    private Button closer;

    private Button save;
    private Button load;
    private Button export;
    private Stage stage1;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Фракталы");
        Parent parent = initInterface();
        initInteraction();

        stage.setScene(new Scene(parent));
        stage.show();
        stage1 = stage;
    }

    private Parent initInterface() {
        img = new WritableImage(W, H);
        display = new Display(x0, y0, d);
        mandelbrot = new Mandelbrot();
        display.paint(img, mandelbrot);

        ImageView imageView = new ImageView(img);
        HBox.setHgrow(imageView, Priority.ALWAYS);

        VBox panel = new VBox();
        HBox bottomPane = new HBox();

        // кнопки навигации
        left = new Button("<");
        right = new Button(">");
        up = new Button("^");
        down = new Button("˅");

        VBox navPane = new VBox();
        HBox notUp = new HBox();
        notUp.getChildren().addAll(left, down, right);
        navPane.getChildren().addAll(up, notUp);
        navPane.setAlignment(Pos.CENTER);

        // приближение-отдаление
        closer = new Button("+");
        further = new Button("-");
        HBox scalePane = new HBox();
        scalePane.getChildren().addAll(further, closer);
        scalePane.setAlignment(Pos.CENTER);

        // сохранить-загрузить-экспорт
        save = new Button("save");
        load = new Button("load");
        export = new Button("export");
        HBox actionPane = new HBox();
        actionPane.getChildren().addAll(save, load, export);
        actionPane.setAlignment(Pos.CENTER);
        actionPane.setSpacing(5);

        bottomPane.getChildren().addAll(navPane, scalePane, actionPane);
        bottomPane.setStyle("-fx-background-color: blue;");
        bottomPane.setPrefHeight(70);
        HBox.setHgrow(bottomPane, Priority.ALWAYS);
        VBox.setVgrow(bottomPane, Priority.ALWAYS);
        bottomPane.setSpacing(50);

        panel.getChildren().addAll(imageView, bottomPane);
        return panel;
    }

    private void initInteraction() {
        left.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            x0 -= W/30.0 * d;
            display = new Display(x0, y0, d);
            display.paint(img, mandelbrot);
        });
        right.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            x0 += W/30.0 * d;
            display = new Display(x0, y0, d);
            display.paint(img, mandelbrot);
        });
        up.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            y0 += H/30.0 * d;
            display = new Display(x0, y0, d);
            display.paint(img, mandelbrot);
        });
        down.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            y0 -= H/30.0 * d;
            display = new Display(x0, y0, d);
            display.paint(img, mandelbrot);
        });
        closer.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            double dd = d - d/1.5;
            x0 += 0.5 * W * dd;
            y0 -= 0.5 * H * dd;
            d = d/1.5;
            display = new Display(x0, y0, d);
            display.paint(img, mandelbrot);
        });
        further.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            double dd = d - d*1.5;
            x0 += 0.5 * W * dd;
            y0 -= 0.5 * H * dd;
            d = d*1.5;
            display = new Display(x0, y0, d);
            display.paint(img, mandelbrot);
        });
        save.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            FileChooser fc = new FileChooser();
            File saveFile = fc.showOpenDialog(stage1);
            try (PrintStream outFile = new PrintStream(saveFile, StandardCharsets.UTF_8)) {
                outFile.println(x0);
                outFile.println(y0);
                outFile.println(d);
                outFile.flush();
            } catch (IOException e) {
                System.out.println("Не удалось записать");
            }
        });
        load.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            FileChooser fc = new FileChooser();
            File loadFile = fc.showOpenDialog(stage1);
            if (loadFile == null)
                System.out.println("Ничего не выбрано");
            else {
                try (Scanner in = new Scanner(loadFile, StandardCharsets.UTF_8)) {
                    x0 = Double.parseDouble(in.next());
                    y0 = Double.parseDouble(in.next());
                    d = Double.parseDouble(in.next());

                    display = new Display(x0, y0, d);
                    display.paint(img, mandelbrot);
                } catch (IOException e) {
                        System.out.println("Не удалось открыть");
                    }
                }
            });
        export.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            FileChooser fc = new FileChooser();
            File exportFile = fc.showOpenDialog(stage1);
            BufferedImage swingImage = SwingFXUtils.fromFXImage(img, null);
            try {
                ImageIO.write(swingImage, "png", exportFile);
            } catch (IOException e) {
                System.out.println("Не удалось записать");
            }
        });

    }
}
