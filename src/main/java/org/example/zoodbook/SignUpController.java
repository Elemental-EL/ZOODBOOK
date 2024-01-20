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

import java.io.*;
import java.util.Objects;

public class SignUpController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView logobtn, backbtn;
    @FXML
    private TextField nameText, familyText, userText, codePText, PhnumberText;
    @FXML
    private PasswordField passwordText, repPasswordText;
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
        errorText.setText("");
        boolean isUnique = true;
        String lastUserId = "101";
        String line;
        if (nameText.getText().trim().isEmpty() || familyText.getText().trim().isEmpty() || userText.getText().trim().isEmpty() || passwordText.getText().trim().isEmpty() || codePText.getText().trim().isEmpty() || PhnumberText.getText().trim().isEmpty() || addressText.getText().trim().isEmpty())
            errorText.setText("*پر کردن تمامی فیلد ها الزامی است.");
        else if ((Objects.equals(userText.getText(), "admin")) || (Objects.equals(passwordText.getText(), "admin")))
            errorText.setText("*شما نمی توانید از این نام کاربری یا رمز عبور استفاده کنید.");
        else if (passwordText.getText().length() < 8)
            errorText.setText("*رمز عبور باید شامل حداقل 8 کاراکتر باشد.");
        else if (!(Objects.equals(passwordText.getText(), repPasswordText.getText())))
            errorText.setText("*تکرار رمز عبور اشتباه است.");
        else if (!codePText.getText().matches("\\d+"))
            errorText.setText("*کد پستی باید تنها شامل عدد باشد.");
        else if (!codePText.getText().matches("\\d{10}"))
            errorText.setText("*کد پستی باید ده رقمی باشد");
        else if (!PhnumberText.getText().matches("\\d+") || !PhnumberText.getText().matches("09\\d{9}"))
            errorText.setText("*فرمت شماره تلفن اشتباه است.");
        else {
            BufferedReader reader0 = new BufferedReader(new FileReader("Files/Users.txt"));
            while (isUnique && (line = reader0.readLine()) != null) {
                if (Objects.equals(userText.getText(), line.split("#")[4]))
                    isUnique = false;
            }
            reader0.close();
            if (!isUnique)
                errorText.setText("*این نام کاربری قبلا استفاده شده است.");
            else {
                StringBuilder userTexts = new StringBuilder();
                BufferedReader reader1 = new BufferedReader(new FileReader("Files/Users.txt"));
                while ((line = reader1.readLine()) != null)
                    lastUserId = line.split("#")[1];
                reader1.close();
                int newId = Integer.parseInt(lastUserId);
                newId++;
                BufferedReader reader2 = new BufferedReader(new FileReader("Files/Users.txt"));
                while ((line = reader2.readLine()) != null)
                    userTexts.append(line + "\n");
                reader2.close();
                StringBuilder newUser = new StringBuilder("#" + newId + "#" + nameText.getText() + "#" + familyText.getText() + "#" + userText.getText() + "#" + passwordText.getText().hashCode() + "#" + addressText.getText() + "#" + codePText.getText() + "#" + PhnumberText.getText() + "#");
                userTexts.append(newUser);
                BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Users.txt"));
                writer.write(String.valueOf(userTexts));
                writer.close();
//                SignInController.loggedInUserId= newId;
                Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
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
