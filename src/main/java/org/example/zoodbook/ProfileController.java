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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

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
    private Text editcredsbtn, errorText;
    public String currentPassword;
    public int uId;
    public void initialize() throws IOException {
        savebtn.setDisable(true);
        uId = SignInController.loggedInUserId;
        BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
        String line;
        while ((line=reader.readLine())!=null) {
            if (String.valueOf(uId).equals(line.split("#")[1])){
                nameText.setText(line.split("#")[2]);
                familyText.setText(line.split("#")[3]);
                userText.setText(line.split("#")[4]);
                //For using in editing.
                currentPassword = line.split("#")[5];
                //
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
        errorText.setText("");
        savebtn.setDisable(false);
        nameText.setEditable(true);
        familyText.setEditable(true);
        codePText.setEditable(true);
        PhnumberText.setEditable(true);
        addressText.setEditable(true);
        editbtn.setDisable(true);
    }
    public void onSaveClicked (ActionEvent event) throws IOException {
        editbtn.setDisable(false);
        errorText.setFill(Color.RED);
        errorText.setText("");
        if (nameText.getText().trim().isEmpty() || familyText.getText().trim().isEmpty() || userText.getText().trim().isEmpty() || codePText.getText().trim().isEmpty() || PhnumberText.getText().trim().isEmpty() || addressText.getText().trim().isEmpty())
            errorText.setText("*پر کردن تمامی فیلد ها الزامی است.");
        else if (nameText.getText().contains("#") || familyText.getText().contains("#") || addressText.getText().contains("#"))
            errorText.setText("*شما نمی توانید از # در اطلاعات خود استفاده کنید.");
        else if (Objects.equals(userText.getText(), "admin"))
            errorText.setText("*شما نمی توانید از این نام کاربری استفاده کنید.");
        else if (!codePText.getText().matches("\\d+"))
            errorText.setText("*کد پستی باید تنها شامل عدد باشد.");
        else if (!codePText.getText().matches("\\d{10}"))
            errorText.setText("*کد پستی باید ده رقمی باشد.");
        else if (!PhnumberText.getText().matches("\\d+") || !PhnumberText.getText().matches("09\\d{9}"))
            errorText.setText("*فرمت شماره تلفن اشتباه است.");
        else {
            BufferedReader reader1 = new BufferedReader(new FileReader("Files/Users.txt"));
            String line;
            StringBuilder userTexts = new StringBuilder();
            while ((line = reader1.readLine()) != null && (!Objects.equals(line.split("#")[1], String.valueOf(uId)))) {
                userTexts.append(line + "\n");
            }
            userTexts.append("#" + uId + "#" + nameText.getText() + "#" + familyText.getText() + "#" + userText.getText() + "#" + currentPassword + "#" + addressText.getText() + "#" + codePText.getText() + "#" + PhnumberText.getText() + "#" + "\n");
            while ((line = reader1.readLine()) != null) {
                userTexts.append(line + "\n");
            }
            reader1.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Users.txt"));
            writer.write(String.valueOf(userTexts));
            writer.close();
            errorText.setFill(Color.GREEN);
            errorText.setText("*اطلاعات شما با موفقیت تغییر یافت.");
            BufferedReader reader2 = new BufferedReader(new FileReader("Files/Users.txt"));
            while ((line = reader2.readLine()) != null) {
                if (String.valueOf(uId).equals(line.split("#")[1])) {
                    nameText.setText(line.split("#")[2]);
                    familyText.setText(line.split("#")[3]);
                    userText.setText(line.split("#")[4]);
                    addressText.setText(line.split("#")[6]);
                    codePText.setText(line.split("#")[7]);
                    PhnumberText.setText(line.split("#")[8]);
                }
            }
            reader2.close();
            nameText.setEditable(false);
            familyText.setEditable(false);
            codePText.setEditable(false);
            PhnumberText.setEditable(false);
            addressText.setEditable(false);
            savebtn.setDisable(true);
        }
    }
    public void onEditCredsClicked (MouseEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("EditCreds.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
}
