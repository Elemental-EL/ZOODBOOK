package org.example.zoodbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("ZOOD BOOK");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("jhjhj.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}