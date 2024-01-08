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

public class historybooksController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button jumpUpbtn, classicbtn, historybtn, biobtn, psychobtn, cookingbtn, scifibtn;
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
    void onCartClicked (MouseEvent event){

    }
    @FXML
    void onLogoClicked (MouseEvent event){

    }
    @FXML
    void onClassicClicked (ActionEvent event){

    }
    @FXML
    void onHistoryClicked (ActionEvent event){

    }
    @FXML
    void onBioClicked (ActionEvent event){

    }
    @FXML
    void onPsychoClicked (ActionEvent event){

    }
    @FXML
    void onCookingClicked (ActionEvent event){

    }
    @FXML
    void onScifiClicked (ActionEvent event){

    }
    @FXML
    void onJumpUpClicked (ActionEvent event){
        scrollPane.setVvalue(0);
    }
}
