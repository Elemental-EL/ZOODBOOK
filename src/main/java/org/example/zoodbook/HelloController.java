package org.example.zoodbook;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Objects;


public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button jumpUpbtn, classicbtn, historybtn, biobtn, psychobtn, cookingbtn, scifibtn, showMoreCl, showMoreHis, showMoreBio, showMorePsycho, showMoreCooking, showMoreScifi;
    @FXML
    private TextField searchBar;
    @FXML
    private ImageView profilebtn, cartbtn, searchbtn, logobtn;
    @FXML
    private Hyperlink link;
    @FXML
    private ScrollPane scrollPane;
    public int uId = SignInController.loggedInUserId;
    public void initialize() throws IOException, NoSuchFieldException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new FileReader("Files/Books.txt"));
        String line;
        int i =1;
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "cl5")){
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            }
            else
                price.setText(line.split("#")[3]+" تومان");
            i++;
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "cl8"));{
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "h5")){
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            }
            else
                price.setText(line.split("#")[3]+" تومان");
            i++;
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "h8"));{
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "b5")){
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            }
            else
                price.setText(line.split("#")[3]+" تومان");
            i++;
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "b8"));{
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "p5")){
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            }
            else
                price.setText(line.split("#")[3]+" تومان");
            i++;
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "p8"));{
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "co5")){
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            }
            else
                price.setText(line.split("#")[3]+" تومان");
            i++;
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "co8"));{
        }
        while ((line= reader.readLine())!=null&& !Objects.equals(line.split("#")[1], "s5")){
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
        while (i<25){
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            Button add = (Button) getClass().getDeclaredField("add"+ i).get(this);
            if (Objects.equals(price.getText(), "ناموجود"))
                add.setDisable(true);
            i++;
        }

    }
    @FXML
    void onUserClicked (MouseEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
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
    void onLogoClicked (MouseEvent event){

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
    void onShowMoreClassic (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("classicbooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onShowMoreHistory (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("historybooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onShowMoreBio (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("biobooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onShowMorePsycho (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("psychobooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onShowMoreCooking (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cooking.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onShowMoreScifi (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scifibooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onSearchClicked (MouseEvent event){

    }
    @FXML
     void onShowMoreInfoClicked(ActionEvent event) throws URISyntaxException,IOException {

    }
    @FXML
    void onClassicLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("classicbooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onHistoryLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("historybooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onBioLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("biobooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onPsychoLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("psychobooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onCookingLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cookingbooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onScifiLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scifibooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onJumpUpClicked (ActionEvent event) {
        scrollPane.setVvalue(0);
    }


    public void onAdd1(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            ordersText.append(read + "c1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd2(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "c2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd3(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            ordersText.append(read + "c3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }

    }

    public void onAdd4(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            ordersText.append(read + "c4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd5(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd6(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
        
    }

    public void onAdd7(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "h3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd8(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd9(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "b1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd10(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "b2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd11(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            ordersText.append(read + "b3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd12(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "b4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd13(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "p1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd14(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "p2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd15(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "p3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd16(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            ordersText.append(read + "p4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd17(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "co1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd18(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "co2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd19(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "co3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd20(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "co4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd21(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "s1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd22(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "s2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd23(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "s3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }

    public void onAdd24(ActionEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine())!=null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "s4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null){
                ordersText.append(read);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
        }
    }



    @FXML
    private HostServices hostServices;
    public void setHostServices(HostServices hostServices){
        this.hostServices=hostServices;
    }
}

