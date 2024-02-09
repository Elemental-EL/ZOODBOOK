package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class AddSuggestionsController {
    @FXML
    private TextArea SuggestionsTXT;
    private Stage stage;
    private Scene scene;

    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    public void onAddSuggClicked(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId != 100){
            BufferedReader reader = new BufferedReader(new FileReader("Files/Suggestions.txt"));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line=reader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }
            reader.close();
            stringBuilder.append("#" + SignInController.loggedInUserId + "#");
            line = SuggestionsTXT.getText();
            StringTokenizer stringTokenizer = new StringTokenizer(line , " \n");
            while (stringTokenizer.hasMoreTokens()){
                stringBuilder.append(stringTokenizer.nextToken()+"#");
            }
            stringBuilder.append("\n");
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Suggestions.txt"));
            writer.write(String.valueOf(stringBuilder));
            writer.close();
            SuggestionsTXT.setText("");
        }
    }
}
