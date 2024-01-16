package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView backbtn,logobtn;
    public void onAddClicked(ActionEvent actionEvent) {
    }

    public void onMinusClicked(ActionEvent actionEvent) {
    }

    public void onRicycleBinClicked(MouseEvent event) {
    }
    public void onLogoClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void onBackClicked(MouseEvent event){

    }
    public List<String> getOrdersByUserId (){

        List<String> userOrders = new ArrayList<>();
        //Get from file

        return userOrders;







    }
}
