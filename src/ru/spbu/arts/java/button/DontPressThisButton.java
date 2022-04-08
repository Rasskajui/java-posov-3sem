package ru.spbu.arts.java.button;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DontPressThisButton extends Application {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private ImageView cat;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Не нажимайте на кнопку!!!");
        stage.setMinWidth(280);
        stage.setMinHeight(300);

        Parent parent = initInterface();
        initInteraction();

        stage.setScene(new Scene(parent));
        stage.show();
    }

    private Parent initInterface() {
        VBox v = new VBox();
        b1 = new Button("Не нажимайте на эту кнопку!!1");
        b2 = new Button("ЗАЧЕМ ВЫ НАЖАЛИ??");
        b3 = new Button("НЕЕЕЕТ, ПРОШУ, ПРЕКРАТИТЕ");
        b4 = new Button("пожалуйста... не надо...");
        Image image = new Image("data:image/jpeg;base64,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");
        cat = new ImageView(image);


        b2.setVisible(false);
        b2.setManaged(false);
        b3.setVisible(false);
        b3.setManaged(false);
        b4.setVisible(false);
        b4.setManaged(false);
        cat.setVisible(false);
        cat.setManaged(false);

        v.getChildren().addAll(b1, b2, b3, b4, cat);
        v.setAlignment(Pos.CENTER);
        return v;
    }

    private void initInteraction() {
        b1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            b1.setVisible(false);
            b1.setManaged(false);
            b2.setVisible(true);
            b2.setManaged(true);
        });
        b2.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            b2.setVisible(false);
            b2.setManaged(false);
            b3.setVisible(true);
            b3.setManaged(true);
        });
        b3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            b3.setVisible(false);
            b3.setManaged(false);
            b4.setVisible(true);
            b4.setManaged(true);
        });
        b4.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            b4.setVisible(false);
            b4.setManaged(false);
            cat.setVisible(true);
            cat.setManaged(true);
        });
    }
}
