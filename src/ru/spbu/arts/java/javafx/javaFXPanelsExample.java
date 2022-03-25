package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class javaFXPanelsExample extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Example with panels");
        stage.show();

        Parent parent = initInterface(); // parent - особый вид узла, корень для сцены
        stage.setScene(new Scene(parent));

        stage.show();

    }

    private Parent initInterface(){
        HBox panel0 = new HBox();
        panel0.setStyle("-fx-background-color: black");

        VBox panel12 = new VBox();
        panel12.setStyle("-fx-background-color: green"); // не должно быть видно

        Pane panel1 = new Pane();
        panel1.setStyle("-fx-background-color: blue");
        Pane panel2 = new Pane();
        panel2.setStyle("-fx-background-color: yellow");
        Pane panel3 = new Pane();
        panel3.setStyle("-fx-background-color: red");

        // constraints

        VBox.setVgrow(panel1, Priority.ALWAYS);
        VBox.setVgrow(panel2, Priority.ALWAYS);

        // ограчничение hgrow = always -> всегда растягивается (еще убираем ограничение на макс ширину)
        HBox.setHgrow(panel12, Priority.ALWAYS);
        // задаем предпочитаемую ширину для правой панельки
        panel3.setPrefWidth(150);


        panel12.getChildren().addAll(panel1, panel2);
        panel0.getChildren().addAll(panel12, panel3);

        return panel0;
    }
}
