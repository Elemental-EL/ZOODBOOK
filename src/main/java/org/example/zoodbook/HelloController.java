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
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;


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


    public void onAdd1(ActionEvent actionEvent) {
    }

    public void onAdd2(ActionEvent actionEvent) {
    }

    public void onAdd3(ActionEvent actionEvent) {

    }

    public void onAdd4(ActionEvent actionEvent) {
    }

    public void onAdd5(ActionEvent actionEvent) {
    }

    public void onAdd6(ActionEvent actionEvent) {

    }

    public void onAdd7(ActionEvent actionEvent) {
    }

    public void onAdd8(ActionEvent actionEvent) {
    }

    public void onAdd9(ActionEvent actionEvent) {
    }

    public void onAdd10(ActionEvent actionEvent) {
    }

    public void onAdd11(ActionEvent actionEvent) {
    }

    public void onAdd12(ActionEvent actionEvent) {
    }

    public void onAdd13(ActionEvent actionEvent) {
    }

    public void onAdd14(ActionEvent actionEvent) {
    }

    public void onAdd15(ActionEvent actionEvent) {
    }

    public void onAdd16(ActionEvent actionEvent) {
    }

    public void onAdd17(ActionEvent actionEvent) {
    }

    public void onAdd18(ActionEvent actionEvent) {
    }

    public void onAdd19(ActionEvent actionEvent) {
    }

    public void onAdd20(ActionEvent actionEvent) {
    }

    public void onAdd21(ActionEvent actionEvent) {
    }

    public void onAdd22(ActionEvent actionEvent) {
    }

    public void onAdd23(ActionEvent actionEvent) {
    }

    public void onAdd24(ActionEvent actionEvent) {
    }



    @FXML
    private HostServices hostServices;
    public void setHostServices(HostServices hostServices){
        this.hostServices=hostServices;
    }
}

