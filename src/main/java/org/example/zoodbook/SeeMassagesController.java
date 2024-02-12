package org.example.zoodbook;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class SeeMassagesController {
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane showMassagesPane;
    @FXML
    private VBox showMassageVbox;

    public void initialize() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Files/Massages.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            if (Objects.equals(line.split("#")[1], String.valueOf(SignInController.loggedInUserId))){
                Text massageDatalbl = new Text("تاریخ دریافت : ");
                Text massageDatatxt = new Text(line.split("#")[2]);
                HBox hBox1 = new HBox(2);
                hBox1.getChildren().addAll(massageDatatxt , massageDatalbl);
                BorderPane firstPane = new BorderPane();
                firstPane.setRight(hBox1);
                firstPane.setStyle("-fx-padding: 8 15 8 8");
                firstPane.getStyleClass().addAll("showUsersTXT" , "lightergreen" , "dataMassage");
                showMassageVbox.getChildren().add(firstPane);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 3 ; i < line.split("#").length ; i++){
                    if (!(line.split("#")[i].contains(".")) && (i < line.split("#").length-1)){
                        stringBuilder.append(line.split("#")[i] + " ");
                    }else{
                        stringBuilder.append(line.split("#")[i]);
                        String line1;
                        line1 = String.valueOf(stringBuilder);
                        stringBuilder.setLength(0);
                        Text showMassage = new Text(line1);
                        BorderPane secondPane = new BorderPane();
                        secondPane.setRight(showMassage);
                        secondPane.getStyleClass().addAll("showUsersTXT" , "lightergreen");
                        secondPane.setStyle("-fx-padding: 0 8 5 0");
                        showMassageVbox.getChildren().add(secondPane);
                    }
                }
                BorderPane spacePane = new BorderPane();
                spacePane.setStyle("-fx-pref-height: 20; -fx-pref-width: 800");
                showMassageVbox.getChildren().add(spacePane);
            }
        }
    }

    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
}
