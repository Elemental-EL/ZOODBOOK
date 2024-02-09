package org.example.zoodbook;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SeeUsersController {
    @FXML
    private AnchorPane userInformationPane;
    @FXML
    private VBox showUsersVbox;
    private Stage stage;
    private Scene scene;

    public void initialize() throws IOException {
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> phoneNumber = new ArrayList<>();
        ArrayList<String> userName = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            firstName.add(line.split("#")[2]);
            lastName.add(line.split("#")[3]);
            phoneNumber.add(line.split("#")[8]);
            userName.add(line.split("#")[4]);
        }
        reader.close();
        showUsers(firstName , lastName , phoneNumber , userName);
    }
    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }
    public void showUsers(ArrayList<String> firstName , ArrayList<String> lastname , ArrayList<String> phoneNumber , ArrayList<String> userName) throws IOException {
        for (int i = 0 ; i < firstName.size() ; i++){
            Text userNum = new Text("(" + String.valueOf(i+1));
            Text userNamelbl = new Text("نام کاربری : ");
            Text userNameTXT = new Text(userName.get(i) + " ");
            Text fullNamelbl = new Text("  نام و نام خانوادگی : ");
            Text fullNameTXT = new Text(firstName.get(i) + " " + lastname.get(i) + " ");
            Text phoneNumberlbl = new Text("  شماره تماس : ");
            Text phoneNumberTXT = new Text( phoneNumber.get(i));
            CheckBox checkBox = new CheckBox();
            HBox hBox = new HBox(8);
            BorderPane borderPane = new BorderPane();
            userNum.getStyleClass().add("showUserslbl");
            userNamelbl.getStyleClass().add("showUserslbl");
            fullNamelbl.getStyleClass().add("showUserslbl");
            phoneNumberlbl.getStyleClass().add("showUserslbl");
            userNameTXT.getStyleClass().add("showUsersTXT");
            fullNameTXT.getStyleClass().add("showUsersTXT");
            phoneNumberTXT.getStyleClass().add("showUsersTXT");
            borderPane.setStyle("-fx-padding: 5");
            hBox.getChildren().addAll(checkBox , phoneNumberTXT , phoneNumberlbl , fullNameTXT , fullNamelbl , userNameTXT , userNamelbl , userNum);
            borderPane.setRight(hBox);
            showUsersVbox.getChildren().add(borderPane);
            if (i >= 12){
                showUsersVbox.setPrefHeight(showUsersVbox.getPrefHeight() + 50);
                userInformationPane.setPrefHeight(userInformationPane.getPrefHeight() + 50);
            }
        }
    }
}
