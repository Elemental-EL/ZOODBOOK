package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

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
    private Hyperlink infolink;
    @FXML
    private ScrollPane scrollPane;
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
    void onCartClicked (MouseEvent event){

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
    void onSearchClicked (ActionEvent event){

    }
    @FXML
    void onInfoLinkClicked (ActionEvent event){

    }
    @FXML
    void onJumpUpClicked (ActionEvent event){
        scrollPane.setVvalue(0);
    }
}