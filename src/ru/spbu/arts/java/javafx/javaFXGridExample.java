package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class javaFXGridExample extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Example with gridPane");
        stage.show();

        Parent parent = initInterface(); // parent - особый вид узла, корень для сцены
        stage.setScene(new Scene(parent));

        stage.show();

    }

    private Parent initInterface(){
        GridPane panel0 = new GridPane();

        Pane panel1 = new Pane();
        panel1.setStyle("-fx-background-color: blue");
        Pane panel2 = new Pane();
        panel2.setStyle("-fx-background-color: yellow");
        Pane panel3 = new Pane();
        panel3.setStyle("-fx-background-color: red");

        panel0.add(panel1, 0, 0);
        panel0.add(panel2, 0,1);
        // 1 - сколько колонок занять, 2 - сколько строк
        panel0.add(panel3, 1, 0, 1, 2);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHgrow(Priority.ALWAYS); // 1 столбец тянется
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPrefWidth(150); // 2 столбец имеет ширину 150px

        panel0.getColumnConstraints().addAll(c1, c2);

        RowConstraints r1 = new RowConstraints();
        r1.setVgrow(Priority.ALWAYS);
        RowConstraints r2 = new RowConstraints();
        r2.setVgrow(Priority.ALWAYS);

        panel0.getRowConstraints().addAll(r1, r2);

        return panel0;
    }
}
