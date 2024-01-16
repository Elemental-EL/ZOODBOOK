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

public class StorageController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView logobtn;
    @FXML
    void onLogoClicked (MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Section.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onEdit1(ActionEvent actionEvent) {
    }

    public void onEdit2(ActionEvent actionEvent) {
    }

    public void onEdit3(ActionEvent actionEvent) {
    }

    public void onEdit4(ActionEvent actionEvent) {
    }

    public void onEdit5(ActionEvent actionEvent) {
    }

    public void onEdit6(ActionEvent actionEvent) {
    }

    public void onEdit7(ActionEvent actionEvent) {
    }

    public void onEdit8(ActionEvent actionEvent) {
    }

    public void onEdit9(ActionEvent actionEvent) {
    }

    public void onEdit10(ActionEvent actionEvent) {
    }

    public void onEdit11(ActionEvent actionEvent) {
    }

    public void onEdit12(ActionEvent actionEvent) {
    }

    public void onEdit13(ActionEvent actionEvent) {
    }

    public void onEdit14(ActionEvent actionEvent) {
    }

    public void onEdit15(ActionEvent actionEvent) {
    }

    public void onEdit16(ActionEvent actionEvent) {
    }

    public void onEdit17(ActionEvent actionEvent) {
    }

    public void onEdit18(ActionEvent actionEvent) {
    }

    public void onEdit19(ActionEvent actionEvent) {
    }

    public void onEdit20(ActionEvent actionEvent) {
    }

    public void onEdit21(ActionEvent actionEvent) {
    }

    public void onEdit22(ActionEvent actionEvent) {
    }

    public void onEdit23(ActionEvent actionEvent) {
    }

    public void onEdit24(ActionEvent actionEvent) {
    }

    public void onEdit25(ActionEvent actionEvent) {
    }

    public void onEdit26(ActionEvent actionEvent) {
    }

    public void onEdit27(ActionEvent actionEvent) {
    }

    public void onEdit28(ActionEvent actionEvent) {
    }

    public void onEdit29(ActionEvent actionEvent) {
    }

    public void onEdit30(ActionEvent actionEvent) {
    }

    public void onEdit31(ActionEvent actionEvent) {
    }

    public void onEdit32(ActionEvent actionEvent) {
    }

    public void onEdit33(ActionEvent actionEvent) {
    }

    public void onEdit34(ActionEvent actionEvent) {
    }

    public void onEdit35(ActionEvent actionEvent) {
    }

    public void onEdit36(ActionEvent actionEvent) {
    }

    public void onEdit37(ActionEvent actionEvent) {
    }

    public void onEdit38(ActionEvent actionEvent) {
    }

    public void onEdit39(ActionEvent actionEvent) {
    }

    public void onEdit40(ActionEvent actionEvent) {
    }

    public void onEdit41(ActionEvent actionEvent) {
    }

    public void onEdit42(ActionEvent actionEvent) {
    }

    public void onEdit43(ActionEvent actionEvent) {
    }

    public void onEdit44(ActionEvent actionEvent) {
    }

    public void onEdit45(ActionEvent actionEvent) {
    }

    public void onEdit46(ActionEvent actionEvent) {
    }

    public void onEdit47(ActionEvent actionEvent) {
    }

    public void onEdit48(ActionEvent actionEvent) {
    }

    public void onChangeSavebtn(ActionEvent actionEvent) {
    }
}
