package org.example.zoodbook;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class OrdersController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView logobtn;
    @FXML
    private VBox mainVbox;

    public void initialize() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Files/Orders.txt"));
        String line ;
        while ((line = reader.readLine())!=null){
            restartOrder(line);
        }
        reader.close();
    }
    @FXML
    void onLogoClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Section.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void restartOrder(String line) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
        String newline;
        while (((newline = reader.readLine())!=null) && (!Objects.equals(newline.split("#")[1], line.split("#")[1]))){
        }
        String Name = newline.split("#")[2];
        String Family = newline.split("#")[3];
        String phoneNumber = newline.split("#")[8];
        String postCode = newline.split("#")[7];
        String Address = newline.split("#")[6];
        Label name = new Label("نام و نام خانوادگی:");
        TextField fillName = new TextField(Name +" "+ Family);
        Label orderCode = new Label("کد سفارش :");
        String code = line.split("#")[2];
        TextField orderCode1 = new TextField(code);
        Label phoneNumber1 = new Label("شماره تماس :");
        TextField phoneNumber2 = new TextField(newline.split("#")[8]);
        Label Address1 = new Label("آدرس :");
        TextField address1 = new TextField(newline.split("#")[6]);
        Label postCode1 = new Label("کد پستی :");
        TextField postcode = new TextField(newline.split("#")[7]);
        BorderPane firstPane = new BorderPane();
        HBox hbox1 = new HBox(6);
        hbox1.getChildren().addAll(phoneNumber2 , phoneNumber1 , orderCode1 , orderCode , fillName , name);
        firstPane.setRight(hbox1);
        mainVbox.getChildren().add(firstPane);
        BorderPane seccondPane = new BorderPane();
        HBox hBox2 = new HBox(4);
        hBox2.getChildren().addAll(address1 , Address1 , postcode , postCode1);
        seccondPane.setRight(hBox2);
        mainVbox.getChildren().add(seccondPane);
        String[] booksID = new String[48];
        String[] booksQuantity = new String[48];
        String[] booksName = new String[48];
        for (int i=0 ; i<(line.split("#").length-6)/2 ; i++){
            booksID[i] = line.split("#")[2*i+6];
            booksQuantity[i] = line.split("#")[2*i+7];
        }
        for (int i=0 ; i<booksID.length && booksID[i]!=null ; i++) {
            BufferedReader reader1 = new BufferedReader(new FileReader("Files/Books.txt"));
            String line1;
            while (((line1 = reader1.readLine()) != null) && ((!Objects.equals(line1.split("#")[1], booksID[i])))) {
            }
            booksName[i] = line1.split("#")[4];
        }
        for (int j=0 ; j<48 && booksID[j]!=null ; j++){
            Label bookNamelbl = new Label("نام کتاب :");
            TextField bookNameFiled = new TextField(booksName[j]);
            Label bookQuantitylbl = new Label("تعداد :");
            TextField bookQuantityField = new TextField(booksQuantity[j]);
            BorderPane repeatPane = new BorderPane();
            HBox repaetHbox = new HBox(4);
            repaetHbox.getChildren().addAll(bookQuantityField , bookQuantitylbl , bookNameFiled , bookNamelbl);
            repeatPane.setRight(repaetHbox);
            mainVbox.getChildren().add(repeatPane);
        }
        Label orderPrice = new Label("مبلغ کل پرداحت شده:");
        TextField orderPrice1 = new TextField(line.split("#")[4]);
        Label orderDate = new Label("تاریخ ثبت سفارش :");
        TextField orderDate1 = new TextField(line.split("#")[3]);
        HBox lastHBox = new HBox(4);
        lastHBox.getChildren().addAll(orderDate1 , orderDate , orderPrice1 , orderPrice);
        BorderPane lastPane = new BorderPane();
        lastPane.setRight(lastHBox);
        mainVbox.getChildren().add(lastPane);
        CheckBox checkBox = new CheckBox();
        HBox hBox = new HBox(1);
        hBox.getChildren().add(checkBox);
        BorderPane chechPane = new BorderPane();
        chechPane.setRight(hBox);
        mainVbox.getChildren().add(chechPane);
    }
}
