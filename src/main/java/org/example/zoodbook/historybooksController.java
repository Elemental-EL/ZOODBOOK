package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.io.*;
import java.util.Objects;

public class historybooksController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button jumpUpbtn, classicbtn, historybtn, biobtn, psychobtn, cookingbtn, scifibtn, add1, add2, add3, add4, add5, add6, add7, add8;
    @FXML
    private ImageView profilebtn, cartbtn, logobtn;
    @FXML
    private Label price1,price2,price3,price4,price5,price6,price7,price8;
    public void initialize() throws IOException, NoSuchFieldException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new FileReader("Files/Books.txt"));
        String line;
        int i=1;
        while ((line=reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "cl8")){
        }
        while ((line=reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "b1")){
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            }
            else
                price.setText(line.split("#")[3]+" تومان");
            i++;
        }
        reader.close();
        i=1;
        while (i<9){
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            Button add = (Button) getClass().getDeclaredField("add"+ i).get(this);
            if (Objects.equals(price.getText(), "ناموجود"))
                add.setDisable(true);
            i++;
        }
    }
    @FXML
    void onUserClicked (MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onCartClicked (MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onLogoClicked (MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onClassicClicked (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("classicbooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onHistoryClicked (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("historybooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onBioClicked (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("biobooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onPsychoClicked (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("psychobooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onCookingClicked (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cookingbooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onScifiClicked (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scifibooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onJumpUpClicked (ActionEvent event){
        scrollPane.setVvalue(0);
    }
    @FXML
    void onAdd1(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100){
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "h1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }
    @FXML
    void onAdd2(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100){
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "h2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }
    @FXML
    void onAdd3(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100){
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "h3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }
    @FXML
    void onAdd4(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100){
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "h4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }
    @FXML
    void onAdd5(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100){
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "h5" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }
    @FXML
    void onAdd6(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100){
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "h6" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }
    @FXML
    void onAdd7(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100){
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "h7" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }
    @FXML
    void onAdd8(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100){
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "h8" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }
}
