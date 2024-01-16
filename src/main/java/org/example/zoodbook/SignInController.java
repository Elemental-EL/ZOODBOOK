package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignInController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView backbtn,logobtn;
    @FXML
    private TextField usernameText, passwordText;
    @FXML
    private Button loginbtn;
    @FXML
    private Text signUpbtn,errorText;
    @FXML
    void onLogoClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onBackClicked(MouseEvent event){

    }
    @FXML
    void onSignUpClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sign-Up.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void onLoginClicked(ActionEvent event) throws IOException {
        if (usernameText.getText().trim().isEmpty()||passwordText.getText().trim().isEmpty()){
            errorText.setText("*پر کردن تمامی فیلد ها الزامی است.");
        }
        else if (Objects.equals(usernameText.getText(), "admin") & Objects.equals(passwordText.getText(), "admin")){
            Parent root = FXMLLoader.load(getClass().getResource("Section.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
