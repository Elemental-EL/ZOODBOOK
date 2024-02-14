package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class UserPanelController {
    private Stage stage;
    private Long number;
    private Scene scene;
    private Parent root;
    @FXML
    private Label userNamelbl;
    @FXML
    private Pane notifPane;
    @FXML
    private Text notifCount;
    private int notifC =0;
    public void initialize() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            if (Objects.equals(line.split("#")[1], String.valueOf(SignInController.loggedInUserId))){
                String newLine;
                newLine = line.split("#")[4];
                userNamelbl.setText(newLine);
            }
        }
        reader.close();
        BufferedReader reader0 = new BufferedReader(new FileReader("Files/Massages.txt"));
        while ((line = reader0.readLine()) != null){
            if (Objects.equals(line.split("#")[1], String.valueOf(SignInController.loggedInUserId))){
                if (Objects.equals(line.split("#")[3], "0"))
                    notifC++;
            }
        }
        reader0.close();
        if (notifC==0)
            notifPane.setVisible(false);
        else
            notifCount.setText(String.valueOf(notifC));
    }
    public void onLogoClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    public void onSeeInfoClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    public void onCartClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    public void onAddSuggestionClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddSuggestions.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    public void onLogOutClicked(ActionEvent event) throws IOException {
        SignInController.loggedInUserId = 100;
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public void onBackToMainPageClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public void onSeeMassagesClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SeeMassages.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }
}
