package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView logobtn, backbtn;
    @FXML
    private TextField nameText, familyText, userText, passwordText, codePText, PhnumberText;
    @FXML
    private TextArea addressText;
    @FXML
    private Button editbtn, savebtn;
    @FXML
    private Text editcredsbtn;
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

    }
    public void onSaveClicked (ActionEvent event){

    }
    public void onEditCredsClicked (ActionEvent event){

    }
}
