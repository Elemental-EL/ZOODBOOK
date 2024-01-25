package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StorageController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView logobtn;
    @FXML
    private TextField quantity1,quantity2,quantity3,quantity4,quantity5,quantity6,quantity7,quantity8,quantity9,quantity10,quantity11,quantity12,quantity13,quantity14,quantity15,quantity16,quantity17,quantity18,quantity19,quantity20,quantity21,quantity22,quantity23,quantity24,quantity25,quantity26,quantity27,quantity28,quantity29,quantity30,quantity31,quantity32,quantity33,quantity34,quantity35,quantity36,quantity37,quantity38,quantity39,quantity40,quantity41,quantity42,quantity43,quantity44,quantity45,quantity46,quantity47,quantity48,price1,price2,price3,price4,price5,price6,price7,price8,price9,price10,price11,price12,price13,price14,price15,price16,price17,price18,price19,price20,price21,price22,price23,price24,price25,price26,price27,price28,price29,price30,price31,price32,price33,price34,price35,price36,price37,price38,price39,price40,price41,price42,price43,price44,price45,price46,price47,price48;
    @FXML
    private Button ChangeSavebtn;
    public void initialize() throws IOException, NoSuchFieldException, IllegalAccessException {
        ChangeSavebtn.setDisable(true);
        BufferedReader reader = new BufferedReader(new FileReader("Files/Books.txt"));
        String line;
        for (int i=1;i<=48;i++){
            line=reader.readLine();
            TextField priceField = (TextField) getClass().getDeclaredField("price" + i).get(this);
            TextField quantityField = (TextField) getClass().getDeclaredField("quantity" + i).get(this);
            quantityField.setText(line.split("#")[2]);
            priceField.setText(line.split("#")[3]+" تومان");
        }
        reader.close();
    }
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
        quantity1.setEditable(true);
        price1.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit2(ActionEvent actionEvent) {
        quantity2.setEditable(true);
        price2.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit3(ActionEvent actionEvent) {
        quantity3.setEditable(true);
        price3.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit4(ActionEvent actionEvent) {
        quantity4.setEditable(true);
        price4.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit5(ActionEvent actionEvent) {
        quantity5.setEditable(true);
        price5.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit6(ActionEvent actionEvent) {
        quantity6.setEditable(true);
        price6.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit7(ActionEvent actionEvent) {
        quantity7.setEditable(true);
        price7.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit8(ActionEvent actionEvent) {
        quantity8.setEditable(true);
        price8.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit9(ActionEvent actionEvent) {
        quantity9.setEditable(true);
        price9.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit10(ActionEvent actionEvent) {
        quantity10.setEditable(true);
        price10.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit11(ActionEvent actionEvent) {
        quantity11.setEditable(true);
        price11.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit12(ActionEvent actionEvent) {
        quantity12.setEditable(true);
        price12.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit13(ActionEvent actionEvent) {
        quantity13.setEditable(true);
        price13.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit14(ActionEvent actionEvent) {
        quantity14.setEditable(true);
        price14.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit15(ActionEvent actionEvent) {
        quantity15.setEditable(true);
        price15.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit16(ActionEvent actionEvent) {
        quantity16.setEditable(true);
        price16.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit17(ActionEvent actionEvent) {
        quantity17.setEditable(true);
        price17.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit18(ActionEvent actionEvent) {
        quantity18.setEditable(true);
        price18.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit19(ActionEvent actionEvent) {
        quantity19.setEditable(true);
        price19.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit20(ActionEvent actionEvent) {
        quantity20.setEditable(true);
        price20.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit21(ActionEvent actionEvent) {
        quantity21.setEditable(true);
        price21.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit22(ActionEvent actionEvent) {
        quantity22.setEditable(true);
        price22.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit23(ActionEvent actionEvent) {
        quantity23.setEditable(true);
        price23.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit24(ActionEvent actionEvent) {
        quantity24.setEditable(true);
        price24.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit25(ActionEvent actionEvent) {
        quantity25.setEditable(true);
        price25.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit26(ActionEvent actionEvent) {
        quantity26.setEditable(true);
        price26.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit27(ActionEvent actionEvent) {
        quantity27.setEditable(true);
        price27.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit28(ActionEvent actionEvent) {
        quantity28.setEditable(true);
        price28.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit29(ActionEvent actionEvent) {
        quantity29.setEditable(true);
        price29.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit30(ActionEvent actionEvent) {
        quantity30.setEditable(true);
        price30.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit31(ActionEvent actionEvent) {
        quantity31.setEditable(true);
        price31.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit32(ActionEvent actionEvent) {
        quantity32.setEditable(true);
        price32.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit33(ActionEvent actionEvent) {
        quantity33.setEditable(true);
        price33.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit34(ActionEvent actionEvent) {
        quantity34.setEditable(true);
        price34.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit35(ActionEvent actionEvent) {
        quantity35.setEditable(true);
        price35.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit36(ActionEvent actionEvent) {
        quantity36.setEditable(true);
        price36.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit37(ActionEvent actionEvent) {
        quantity37.setEditable(true);
        price37.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit38(ActionEvent actionEvent) {
        quantity38.setEditable(true);
        price38.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit39(ActionEvent actionEvent) {
        quantity39.setEditable(true);
        price39.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit40(ActionEvent actionEvent) {
        quantity40.setEditable(true);
        price40.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit41(ActionEvent actionEvent) {
        quantity41.setEditable(true);
        price41.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit42(ActionEvent actionEvent) {
        quantity42.setEditable(true);
        price42.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit43(ActionEvent actionEvent) {
        quantity43.setEditable(true);
        price43.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit44(ActionEvent actionEvent) {
        quantity44.setEditable(true);
        price44.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit45(ActionEvent actionEvent) {
        quantity45.setEditable(true);
        price45.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit46(ActionEvent actionEvent) {
        quantity46.setEditable(true);
        price46.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit47(ActionEvent actionEvent) {
        quantity47.setEditable(true);
        price47.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onEdit48(ActionEvent actionEvent) {
        quantity48.setEditable(true);
        price48.setEditable(true);
        ChangeSavebtn.setDisable(false);
    }

    public void onChangeSavebtn(ActionEvent actionEvent) {
    }
}
