package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.StringTokenizer;

public class SendMassageController {
    private Stage stage;
    private Scene scene;
    @FXML
    private ChoiceBox<String> choiceUsersBox;
    @FXML
    private TextArea entryMassage;
    @FXML
    private Label massageTXTError;
    @FXML
    private Label userErortxt;
    String userID;


    public void initialize() throws IOException {
        ArrayList<String> showUsers = new ArrayList<>();
        showUsers.add("همه کاربران");
        BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            showUsers.add(line.split("#")[4]);
        }
        reader.close();
        choiceUsersBox.getItems().addAll(showUsers);
    }

    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public void onSendMassageClicked(ActionEvent event) throws IOException {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = dateFormat.format(currentDate);
        String userName = choiceUsersBox.getValue();
        if (userName != null){
            if (!entryMassage.getText().trim().isEmpty()){
                if (!userName.equals("همه کاربران")){
                    BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
                    String line1;
                    while ((line1 = reader.readLine()) != null){
                        if (Objects.equals(line1.split("#")[4], userName)){
                            userID = line1.split("#")[1];
                        }
                    }
                    reader.close();
                    BufferedReader reader1 = new BufferedReader(new FileReader("Files/Massages.txt"));
                    String line2;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line2 = reader1.readLine()) != null){
                        stringBuilder.append(line2 + "\n");
                    }
                    reader1.close();
                    line2 = entryMassage.getText();
                    stringBuilder.append("#" + userID + "#" + formattedDate + "#");
                    StringTokenizer stringTokenizer = new StringTokenizer(line2 , " \n");
                    while (stringTokenizer.hasMoreTokens()){
                        stringBuilder.append(stringTokenizer.nextToken() + "#");
                    }
                    stringBuilder.append("\n");
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Massages.txt"));
                    writer.write(String.valueOf(stringBuilder));
                    writer.close();
                    entryMassage.setText("");
                }else {
                    ArrayList<String> usersID = new ArrayList<>();
                    BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
                    String newLine;
                    while ((newLine = reader.readLine()) != null){
                        usersID.add(newLine.split("#")[1]);
                    }
                    reader.close();
                    BufferedReader reader1 = new BufferedReader(new FileReader("Files/Massages.txt"));
                    String newLine1;
                    StringBuilder stringBuilder1 = new StringBuilder();
                    while ((newLine1 = reader1.readLine()) != null){
                        stringBuilder1.append(newLine1 + "\n");
                    }
                    reader1.close();
                    newLine1 = entryMassage.getText();
                    for (String id: usersID) {
                        stringBuilder1.append("#" + id + "#" + formattedDate + "#");
                        StringTokenizer stringTokenizer1 = new StringTokenizer(newLine1 , " \n");
                        while (stringTokenizer1.hasMoreTokens()){
                            stringBuilder1.append(stringTokenizer1.nextToken() + "#");
                        }
                        stringBuilder1.append("\n");
                    }
                    BufferedWriter writer1 = new BufferedWriter(new FileWriter("Files/Massages.txt"));
                    writer1.write(String.valueOf(stringBuilder1));
                    writer1.close();
                    entryMassage.setText("");
                }
                massageTXTError.setText("");
            }else {
                massageTXTError.setText("لطفا پیامی وارد نمایید!!");
            }
            userErortxt.setText("");
        }else {
            userErortxt.setText("انتخاب کاربر الزامی میباشد");
        }
    }
}
