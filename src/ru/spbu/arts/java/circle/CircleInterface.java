package ru.spbu.arts.java.circle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static javafx.scene.layout.VBox.*;

public class CircleInterface extends Application {
    private Slider slider;
    private Circle circle;
    private Pane bg;
    private ColorPicker circleColor;
    private ColorPicker bgColor;

    @Override
    public void start(Stage Stage){
        Stage.setTitle("Настраиваемый круг");
        Stage.setWidth(600);
        Stage.setHeight(300);

        Parent parent = initInterface();
        initInteraction();

        Stage.setScene(new Scene(parent));
        Stage.show();
    }

    private Parent initInterface() {
        HBox panel = new HBox();

        VBox panelLeft = new VBox();
        Label sliderLabel = new Label("Размер круга:");
        slider = new Slider();
        Label circleColorLabel = new Label("Цвет круга:");
        circleColor = new ColorPicker();
        Label bgColorLabel = new Label("Цвет фона:");
        bgColor = new ColorPicker();
        panelLeft.getChildren().addAll(
                sliderLabel, slider, circleColorLabel, circleColor, bgColorLabel, bgColor
        );
        panelLeft.setPrefWidth(170);
        setVgrow(panelLeft, Priority.ALWAYS);

        bg = new Pane();
        bg.setStyle("-fx-background-color: white");
        circle = new Circle();
        bg.getChildren().add(circle);
        setVgrow(bg, Priority.ALWAYS);
        HBox.setHgrow(bg, Priority.ALWAYS);

        panel.getChildren().addAll(panelLeft, bg);
        return panel;
    }

    private void initInteraction(){
        circle.radiusProperty().bind(slider.valueProperty());
        circle.centerXProperty().bind(bg.widthProperty().divide(2));
        circle.centerYProperty().bind(bg.heightProperty().divide(2));
        circle.fillProperty().bind(circleColor.valueProperty());
        bgColor.setOnAction(t -> {
            Color color = bgColor.getValue();
            bg.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
        });
        bg.widthProperty().addListener(o -> {
            if (bg.getWidth() < bg.getHeight()) {
                slider.maxProperty().bind(bg.widthProperty().divide(2));
            } else {
                slider.maxProperty().bind(bg.heightProperty().divide(2));
            }
        });
        bg.heightProperty().addListener(o -> {
            if (bg.getWidth() < bg.getHeight()) {
                slider.maxProperty().bind(bg.widthProperty().divide(2));
            } else {
                slider.maxProperty().bind(bg.heightProperty().divide(2));
            }
        });
    }
}
