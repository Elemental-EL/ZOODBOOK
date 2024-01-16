package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class classicbooksController {
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
    void onAdd1(ActionEvent event) {
    }
    @FXML
    void onAdd2(ActionEvent event) {
    }
    @FXML
    void onAdd3(ActionEvent event) {
    }
    @FXML
    void onAdd4(ActionEvent event) {
    }
    @FXML
    void onAdd5(ActionEvent event) {
    }
    @FXML
    void onAdd6(ActionEvent event) {
    }
    @FXML
    void onAdd7(ActionEvent event) {
    }
    @FXML
    void onAdd8(ActionEvent event) {
    }
}
