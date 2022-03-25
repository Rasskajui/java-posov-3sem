package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class javaFXExample2 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Example with vertical buttons");
        stage.show();

        Parent parent = initInterface(); // parent - особый вид узла, корень для сцены
        stage.setScene(new Scene(parent));

        stage.show();

    }

    private VBox initInterface() {
        Button b1 = new Button("Press me, senpai");
        Button b2 = new Button("me too!!");
        Button b3 = new Button("No me first!!!");
        Button b4 = new Button("Not me though");

        VBox v = new VBox(b1, b2, b3);
        v.getChildren().add(b4); // как еще добавить кнопочку

        Label l1 = new Label("Здесь ничего не написано");
        TextField t1 = new TextField();
        Slider s = new Slider(0, 10 ,20);
        HBox h = new HBox(l1, t1, s); // горизонтальный ряд из них, элементы прижмутся к левому краю

        v.getChildren().add(h); // добавляем к вертикальной колонке

        v.setAlignment(Pos.CENTER); // настройка расположения элементов
        v.setSpacing(8); // 8px между подузлами

        h.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
//        h.setStyle("-fx-background-color: red"); // то же самое через CSS

        return v;
    }
}

