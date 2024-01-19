package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProfileController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView logobtn, backbtn;
    @FXML
    private TextField nameText, familyText, userText, codePText, PhnumberText;
    @FXML
    private TextArea addressText;
    @FXML
    private Button editbtn, savebtn;
    @FXML
    private Text editcredsbtn;
    public void initialize() throws IOException {
        savebtn.setDisable(true);
        int uId = SignInController.loggedInUserId;
        BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
        String line;
        while ((line=reader.readLine())!=null) {
            if (String.valueOf(uId).equals(line.split("#")[1])){
                nameText.setText(line.split("#")[2]);
                familyText.setText(line.split("#")[3]);
                userText.setText(line.split("#")[4]);
                addressText.setText(line.split("#")[6]);
                codePText.setText(line.split("#")[7]);
                PhnumberText.setText(line.split("#")[8]);
            }
        }
        reader.close();
    }
    public void onBackClicked(MouseEvent event) throws IOException {

    }
    public void onLogoClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onEditClicked (ActionEvent event){
        savebtn.setDisable(false);

        editbtn.setDisable(true);
    }
    public void onSaveClicked (ActionEvent event){
        editbtn.setDisable(false);

        savebtn.setDisable(true);
    }
    public void onEditCredsClicked (ActionEvent event){

    }
}
