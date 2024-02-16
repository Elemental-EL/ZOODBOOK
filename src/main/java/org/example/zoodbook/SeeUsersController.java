package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class SeeUsersController {
    @FXML
    private AnchorPane userInformationPane;
    @FXML
    private VBox showUsersVbox;
    private Stage stage;
    private Scene scene;
    private String line;


    public void initialize() throws IOException {
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> phoneNumber = new ArrayList<>();
        ArrayList<String> userName = new ArrayList<>();
        ArrayList<String> userId = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            userId.add(line.split("#")[1]);
            firstName.add(line.split("#")[2]);
            lastName.add(line.split("#")[3]);
            phoneNumber.add(line.split("#")[8]);
            userName.add(line.split("#")[4]);
        }
        reader.close();
        showUsers(firstName , lastName , phoneNumber , userName , userId);
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
    public void showUsers(ArrayList<String> firstName , ArrayList<String> lastname , ArrayList<String> phoneNumber , ArrayList<String> userName , ArrayList<String> userId) throws IOException {
        for (int i = 0 ; i < firstName.size() ; i++){
            Text userNum = new Text("(" + String.valueOf(i+1));
            Text userNamelbl = new Text("نام کاربری : ");
            Text userNameTXT = new Text(userName.get(i) + " ");
            Text fullNamelbl = new Text("  نام و نام خانوادگی : ");
            Text fullNameTXT = new Text(firstName.get(i) + " " + lastname.get(i) + " ");
            Text phoneNumberlbl = new Text("  شماره تماس : ");
            Text phoneNumberTXT = new Text( phoneNumber.get(i));
            Button disable = new Button("غیر فعال کردن");
            HBox hBox = new HBox(8);
            BorderPane borderPane = new BorderPane();
            userNum.getStyleClass().add("showUserslbl");
            userNamelbl.getStyleClass().add("showUserslbl");
            fullNamelbl.getStyleClass().add("showUserslbl");
            phoneNumberlbl.getStyleClass().add("showUserslbl");
            userNameTXT.getStyleClass().add("showUsersTXT");
            fullNameTXT.getStyleClass().add("showUsersTXT");
            phoneNumberTXT.getStyleClass().add("showUsersTXT");
            disable.getStyleClass().add( "seeUsersDisable");
            borderPane.setStyle("-fx-padding: 5");
            hBox.getChildren().addAll(disable , phoneNumberTXT , phoneNumberlbl , fullNameTXT , fullNamelbl , userNameTXT , userNamelbl , userNum);
            borderPane.setRight(hBox);
            showUsersVbox.getChildren().add(borderPane);
            int finalI = i;

            BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
            while (((line = reader.readLine()) != null) && (!Objects.equals(line.split("#")[1], userId.get(i)))){
            }
            if (Objects.equals(line.split("#")[9], "0")){
                disable.getStyleClass().add("seeUsersDisable");
                disable.setText("غیر فعال کردن");
            } else if (Objects.equals(line.split("#")[9], "1")) {
                disable.getStyleClass().add("seeUsersDisable1");
                disable.setText("فعال کردن");
            }
            reader.close();
            disable.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new FileReader("Files/Users.txt"));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true){
                        try {
                            if (!((line = reader.readLine()) != null)) break;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        if (Objects.equals(line.split("#")[1], userId.get(finalI))){
                            if (Objects.equals(line.split("#")[9], "0")){
                                stringBuilder.append("#" + line.split("#")[1] + "#" + line.split("#")[2] + "#" + line.split("#")[3] + "#" + line.split("#")[4] + "#" + line.split("#")[5] + "#" + line
                                        .split("#")[6] + "#" + line.split("#")[7] + "#" + line.split("#")[8] + "#" + "1" + "#" + "\n");
                                disable.setText("فعال کردن");
                                disable.setStyle("-fx-background-color: #86A789");
                            } else if (Objects.equals(line.split("#")[9], "1")) {
                                stringBuilder.append("#" + line.split("#")[1] + "#" + line.split("#")[2] + "#" + line.split("#")[3] + "#" + line.split("#")[4] + "#" + line.split("#")[5] + "#" + line
                                        .split("#")[6] + "#" + line.split("#")[7] + "#" + line.split("#")[8] + "#" + "0" + "#" + "\n");
                                disable.setText("غیر فعال کردن");
                                disable.setStyle("-fx-background-color: #164c35");
                            }
                        }else {
                            stringBuilder.append(line + "\n");
                        }
                    }
                    try {
                        reader.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    BufferedWriter writer = null;
                    try {
                        writer = new BufferedWriter(new FileWriter("Files/Users.txt"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        writer.write(String.valueOf(stringBuilder));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        writer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            if (i >= 12){
                showUsersVbox.setPrefHeight(showUsersVbox.getPrefHeight() + 50);
                userInformationPane.setPrefHeight(userInformationPane.getPrefHeight() + 50);
            }
        }
    }
}
