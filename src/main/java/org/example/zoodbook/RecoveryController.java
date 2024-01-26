package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class RecoveryController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView backbtn, logobtn;
    @FXML
    private TextField usernameText, PhNumberText;
    @FXML
    private Button Recoverybtn;
    @FXML
    private Text errorText;
    public static boolean onRecovery=false;
    @FXML
    void onLogoClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onRecoveryClicked(ActionEvent event) throws IOException {
        errorText.setText("");
        if (usernameText.getText().trim().isEmpty() || PhNumberText.getText().trim().isEmpty()) {
            errorText.setText("*پر کردن تمامی فیلد ها الزامی است.");
        } else {
            String entryUsername, line = null;
            String entryPhNumber;
            boolean Authentication = false;
            entryUsername = usernameText.getText();
            entryPhNumber = PhNumberText.getText();
            BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
            while (!Authentication && ((line = reader.readLine()) != null)) {
                if (Objects.equals(entryUsername, line.split("#")[4])) {
                    if (Objects.equals(entryPhNumber, line.split("#")[8])) {
                        Authentication = true;

                    }
                }
            }
            reader.close();
            if (Authentication){
                SignInController.loggedInUserId = Integer.parseInt(line.split("#")[1]);
                onRecovery =true;
                Parent root = FXMLLoader.load(getClass().getResource("EditCreds.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
            else {
                errorText.setText("*نام کاربری یا شماره تلفن اشتباه است.");
            }
        }
    }
}


