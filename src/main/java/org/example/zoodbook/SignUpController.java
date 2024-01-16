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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpController {
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
    private Button signupbtn;
    @FXML
    private Text errorText;

    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void onSignUpClicked(ActionEvent event) throws IOException {

        if (nameText.getText().trim().isEmpty()||familyText.getText().trim().isEmpty()||userText.getText().trim().isEmpty()||passwordText.getText().trim().isEmpty()||codePText.getText().trim().isEmpty()||PhnumberText.getText().trim().isEmpty()||addressText.getText().trim().isEmpty()){
            errorText.setText("*پر کردن تمامی فیلد ها الزامی است.");
        }



       // BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Users.txt"));
//        StringBuilder stringBuilder = new StringBuilder("text gotten from file");
//        StringBuilder newUser =new StringBuilder(nameText.getText() +"#"+ familyText.getText() +"#"+userText.getText()+"#"+passwordText.getText().hashCode()+"#"+codePText.getText()+"#"+PhnumberText.getText()+"#"+addressText.getText());
//        stringBuilder.append("\n"+newUser);
//        System.out.println(stringBuilder);
       // User newUser1 = new User(nameText.getText(),);
         //       registerNewUser(newUser1);

    }



    public void onLogoClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
