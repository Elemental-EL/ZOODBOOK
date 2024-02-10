package org.example.zoodbook;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
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
import java.util.Objects;

public class SeeSuggestionsController {
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane SuggestionsPane;
    @FXML
    private VBox seeSuggestionVbox;
    String userName;
    public void initialize() throws IOException {
        showSuggestions();
    }
    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    public void showSuggestions() throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("Files/Suggestions.txt"));
        String line1;
        while ((line1 = reader1.readLine()) != null){
            BufferedReader reader2 = new BufferedReader(new FileReader("Files/Users.txt"));
            String line2;
            while ((line2 = reader2.readLine()) != null){
                if (Objects.equals(line2.split("#")[1], line1.split("#")[1])){
                    userName = line2.split("#")[4];
                }
            }
            reader2.close();
            Text userNamelbl = new Text(" نام کاربر : ");
            Text userNametxt = new Text(userName);
            userNametxt.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
            userNamelbl.setStyle("-fx-font-size: 20; -fx-font-style: italic;");
            HBox hBox = new HBox(2);
            hBox.getChildren().addAll(userNametxt , userNamelbl);
            BorderPane borderPane1 = new BorderPane();
            borderPane1.getStyleClass().add("lightergreen");
            borderPane1.setRight(hBox);
            seeSuggestionVbox.getChildren().add(borderPane1);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 2 ; i < line1.split("#").length ; i++){
                if (!(line1.split("#")[i].contains(".")) && (i < line1.split("#").length-1)){
                    stringBuilder.append(line1.split("#")[i] + " ");
                }else{
                    stringBuilder.append(line1.split("#")[i]);
                    String line3;
                    line3 = String.valueOf(stringBuilder);
                    stringBuilder.setLength(0);
                    Text showSugg = new Text("     " + line3);
                    showSugg.setStyle("-fx-font-size: 17; -fx-padding: 0 15 0 0");
                    BorderPane borderPane2 = new BorderPane();
                    borderPane2.setRight(showSugg);
                    borderPane2.getStyleClass().add("lightergreen");
                    seeSuggestionVbox.getChildren().add(borderPane2);
                }
            }
            BorderPane spacePane = new BorderPane();
            spacePane.setStyle("-fx-pref-height: 20");
            seeSuggestionVbox.getChildren().add(spacePane);
            seeSuggestionVbox.setPrefHeight(seeSuggestionVbox.getPrefHeight() + 75);
            SuggestionsPane.setPrefHeight(SuggestionsPane.getPrefHeight() + 75);
        }
        reader1.close();
    }
}

