package ru.spbu.arts.java.messenger;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessengerInterface extends Application {

    private Button sendBtn;
    private TextArea messages;
    private TextField newMessage;

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("MyMessenger");

        Parent parent = initInterface();
        initInteraction();

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    private Parent initInterface() {
        HBox panel0 = new HBox();
        VBox panelLeft = new VBox();
        VBox panelRight = new VBox();
        HBox.setHgrow(panelLeft, Priority.ALWAYS);

        // элементы левой панели
        messages = new TextArea();
        messages.setEditable(false);
        VBox.setVgrow(messages, Priority.ALWAYS);
        HBox panelSend = new HBox();
        newMessage = new TextField();
        HBox.setHgrow(newMessage, Priority.ALWAYS);
        sendBtn = new Button("Отправить");
        sendBtn.setPrefWidth(100);

        //элементы правой панели
        Label contactTitle = new Label("Контакты");
        contactTitle.setPrefHeight(20);
        ListView<String> contactList = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList("Мама", "Котик", "Ира ногти");
        contactList.setItems(items);
        VBox.setVgrow(contactList, Priority.ALWAYS);

        panelSend.getChildren().addAll(newMessage, sendBtn);
        panelLeft.getChildren().addAll(messages, panelSend);
        panelRight.getChildren().addAll(contactTitle, contactList);
        panel0.getChildren().addAll(panelLeft, panelRight);

        return panel0;
    }

    private void initInteraction() {
        sendBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            String message = newMessage.getText();
            if (!message.equals("")){
                messages.appendText(message + "\n");
            }
            newMessage.setText("");
        });
    }

}
