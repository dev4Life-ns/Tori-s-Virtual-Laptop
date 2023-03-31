package com.example.onscreenkeyboards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VKeyboardApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VKeyboardApp.class.getResource("keyboardView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 860, 604);
        stage.setTitle("Tori's Virtual Laptop");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}