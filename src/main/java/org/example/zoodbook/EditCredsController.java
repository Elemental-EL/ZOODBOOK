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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class EditCredsController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView logobtn, backbtn;
    @FXML
    private TextField userText;
    @FXML
    private PasswordField passwordText, repPasswordText;
    @FXML
    private Text errorText;
    @FXML
    private Button savebtn;
    public int uId = SignInController.loggedInUserId;
    public String currentName, currentUser, currentPassword, currentFamily, currentAddress, currentCodeP, currentPhNumber;

    public void initialize() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            if (String.valueOf(uId).equals(line.split("#")[1])) {
                currentName = line.split("#")[2];
                currentFamily = line.split("#")[3];
                currentUser = line.split("#")[4];
                currentPassword = line.split("#")[5];
                currentAddress = line.split("#")[6];
                currentCodeP = line.split("#")[7];
                currentPhNumber = line.split("#")[8];
            }
        }
        reader.close();
    }

    public void onBackClicked(MouseEvent event) throws IOException {
        if (RecoveryController.onRecovery) {
            Parent root = FXMLLoader.load(getClass().getResource("Recovery.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        }
    }

    public void onLogoClicked(MouseEvent event) throws IOException {
        if (!RecoveryController.onRecovery) {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        }
    }

    public void onSaveClicked(ActionEvent event) throws IOException {
        errorText.setText("");
        errorText.setFill(Color.RED);
        if (userText.getText().trim().isEmpty() || passwordText.getText().trim().isEmpty() || repPasswordText.getText().trim().isEmpty())
            errorText.setText("*پر کردن تمامی فیلد ها الزامی است.");
        else if (userText.getText().contains("#"))
            errorText.setText("*شما نمی توانید از # در نام کاربری خود استفاده کنید.");
        else if (Objects.equals(userText.getText(), "admin") || (Objects.equals(passwordText.getText(), "admin")))
            errorText.setText("*شما نمی توانید از این نام کاربری یا رمز عبور استفاده کنید.");
        else if (passwordText.getText().length() < 8)
            errorText.setText("*رمز عبور باید شامل حداقل 8 کاراکتر باشد.");
        else if (!(Objects.equals(passwordText.getText(), repPasswordText.getText())))
            errorText.setText("*تکرار رمز عبور اشتباه است.");
        else {
            boolean isUnique = true;
            String line;
            BufferedReader reader0 = new BufferedReader(new FileReader("Files/Users.txt"));
            while (isUnique && (line = reader0.readLine()) != null) {
                if (Objects.equals(userText.getText(), line.split("#")[4]))
                    isUnique = false;
            }
            reader0.close();
            if (Objects.equals(userText.getText(), currentUser))
                isUnique = true;
            if (!isUnique)
                errorText.setText("*این نام کاربری قبلا استفاده شده است.");
            else {
                BufferedReader reader1 = new BufferedReader(new FileReader("Files/Users.txt"));
                StringBuilder userTexts = new StringBuilder();
                while ((line = reader1.readLine()) != null && (!Objects.equals(line.split("#")[1], String.valueOf(uId)))) {
                    userTexts.append(line + "\n");
                }
                userTexts.append("#" + uId + "#" + currentName + "#" + currentFamily + "#" + userText.getText() + "#" + passwordText.getText().hashCode() + "#" + currentAddress + "#" + currentCodeP + "#" + currentPhNumber + "#" + "\n");
                while ((line = reader1.readLine()) != null) {
                    userTexts.append(line + "\n");
                }
                reader1.close();
                BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Users.txt"));
                writer.write(String.valueOf(userTexts));
                writer.close();
                errorText.setFill(Color.GREEN);
                errorText.setText("*اطلاعات شما با موفقیت تغییر یافت.");
                RecoveryController.onRecovery = false;
            }
        }
    }
}
