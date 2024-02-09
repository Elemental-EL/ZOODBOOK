package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;

public class OrdersController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView logobtn;
    @FXML
    private VBox mainVbox;
    @FXML
    private AnchorPane ordersAnchorPane;

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
        stage.centerOnScreen();
    }

    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    public void restartOrder(String line) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Files/Users.txt"));
        String newline;
        while ((newline = reader.readLine())!=null && !Objects.equals(newline.split("#")[1], line.split("#")[1])){
        }
        String name1 = newline.split("#")[2];
        String Family = newline.split("#")[3];
        Label name = new Label("نام و نام خانوادگی:");
        TextField fillName = new TextField(name1 +" "+ Family);
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
        firstPane.setStyle("-fx-padding: 20 10 5 10");
        name.getStyleClass().addAll("orderBooksLabel" , "lblsStyle");
        orderCode.getStyleClass().addAll("orderBooksLabel" , "lblsStyle");
        phoneNumber1.getStyleClass().addAll("orderBooksLabel" , "lblsStyle");
        Address1.getStyleClass().addAll("orderBooksLabel" , "lblsStyle");
        postCode1.getStyleClass().addAll("orderBooksLabel" , "lblsStyle");
        fillName.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        orderCode1.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        phoneNumber2.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        address1.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        postcode.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        fillName.setEditable(false);
        orderCode1.setEditable(false);
        phoneNumber2.setEditable(false);
        address1.setEditable(false);
        postcode.setEditable(false);
        phoneNumber2.setStyle("-fx-pref-width: 125");
        orderCode1.setStyle("-fx-pref-width: 50");
        fillName.setStyle("-fx-pref-width: 150");
        HBox hbox1 = new HBox(6);
        hbox1.getChildren().addAll(phoneNumber2 , phoneNumber1 , orderCode1 , orderCode , fillName , name);
        firstPane.setRight(hbox1);
        firstPane.getStyleClass().add("lightergreen");
        mainVbox.getChildren().add(firstPane);
        BorderPane secondPane = new BorderPane();
        secondPane.setStyle("-fx-padding: 5 10 20 10");
        HBox hBox2 = new HBox(4);
        hBox2.getChildren().addAll(address1 , Address1 , postcode , postCode1);
        secondPane.setRight(hBox2);
        secondPane.getStyleClass().add("lightergreen");
        mainVbox.getChildren().add(secondPane);
        reader.close();
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
            reader1.close();
        }
        for (int j=0 ; j<48 && booksID[j]!=null ; j++){
            Label bookNamelbl = new Label( (j+1)+"- نام کتاب :");
            TextField bookNameFiled = new TextField(booksName[j]);
            Label bookQuantitylbl = new Label("تعداد :");
            TextField bookQuantityField = new TextField(booksQuantity[j]);
            bookNamelbl.getStyleClass().addAll("orderBooksLabel" , "lblsStyle");
            bookQuantitylbl.getStyleClass().addAll("orderBooksLabel" , "lblsStyle");
            bookNameFiled.getStyleClass().addAll("orders-txtField", "order-orderBookName");
            bookQuantityField.getStyleClass().addAll("orders-txtField", "order-orderBookName");
            bookNameFiled.setEditable(false);
            bookQuantityField.setEditable(false);
            bookQuantityField.setStyle("-fx-pref-width: 50");
            BorderPane repatePane = new BorderPane();
            HBox repaetHbox = new HBox(4);
            repaetHbox.getChildren().addAll(bookQuantityField , bookQuantitylbl , bookNameFiled , bookNamelbl);
            repatePane.setRight(repaetHbox);
            repatePane.setStyle("-fx-padding: 5 30 5 10");
            repatePane.getStyleClass().add("lightergreen");
            mainVbox.getChildren().add(repatePane);
        }
        Label orderPrice = new Label("مبلغ کل پرداحت شده:");
        TextField orderPrice1 = new TextField(line.split("#")[4]);
        Label orderDate = new Label("تاریخ ثبت سفارش :");
        TextField orderDate1 = new TextField(line.split("#")[3]);
        orderPrice.getStyleClass().addAll("orderBooksLabel","lblsStyle");
        orderDate.getStyleClass().addAll("orderBooksLabel" , "lblsStyle");
        orderPrice1.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        orderDate1.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        orderPrice1.setEditable(false);
        orderDate1.setEditable(false);
        HBox lastHBox = new HBox(4);
        lastHBox.getChildren().addAll(orderDate1 , orderDate , orderPrice1 , orderPrice);
        BorderPane lastPane = new BorderPane();
        lastPane.setStyle("-fx-padding: 20 10 5 10");
        lastPane.setRight(lastHBox);
        lastPane.getStyleClass().add("lightergreen");
        mainVbox.getChildren().add(lastPane);
        CheckBox checkBox = new CheckBox();
        checkBox.setPrefWidth(30);
        checkBox.setPrefHeight(30);
        Label status = new Label("ارسال شده :");
        status.getStyleClass().addAll("orderBooksLabel" , "lblsStyle");

        for (int i = 0 ; i < booksID.length && booksID[i]!=null ; i++){
            mainVbox.setPrefHeight(mainVbox.getPrefHeight() + 200);
            ordersAnchorPane.setPrefHeight(ordersAnchorPane.getPrefHeight() + 200);
        }

        if (Integer.parseInt(line.split("#")[5])!=0){
            checkBox.setDisable(true);
            checkBox.setSelected(true);
        }
        checkBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkBox.isSelected()){
                    checkBox.setSelected(true);
                    BufferedReader reader1 = null;
                    try {
                        reader1 = new BufferedReader(new FileReader("Files/Orders.txt"));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    String changeLine;
                    while (true){
                        try {
                            if (!(((changeLine = reader1.readLine())!= null) && (!Objects.equals(changeLine.split("#")[2], line.split("#")[2]))))
                                break;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stringBuilder.append(changeLine + "\n");
                    }
                    stringBuilder.append("#"+changeLine.split("#")[1]+"#"+changeLine.split("#")[2]+"#"+changeLine.split("#")[3]+"#"+changeLine.split("#")[4]+"#"+1+"#");
                    for (int i=0 ; i<48 && booksID[i]!=null ; i++){
                        stringBuilder.append(booksID[i]+"#"+booksQuantity[i]+"#");
                    }
                    stringBuilder.append("\n");
                    while (true){
                        try {
                            if (!((changeLine = reader1.readLine())!=null)) break;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stringBuilder.append(changeLine+"\n");
                    }
                    try {
                        reader1.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    BufferedWriter writer = null;
                    try {
                        writer = new BufferedWriter(new FileWriter("Files/Orders.txt"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        writer.write(String.valueOf(stringBuilder));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        writer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    checkBox.setDisable(false);
                }
            }
        });

        HBox hBox = new HBox(2);
        hBox.getChildren().addAll(checkBox , status);
        BorderPane checkPane = new BorderPane();
        checkPane.setStyle("-fx-padding: 10 ");
        checkPane.setRight(hBox);
        checkPane.getStyleClass().add("lightergreen");
        mainVbox.getChildren().add(checkPane);
        BorderPane distance = new BorderPane();
        distance.setPrefHeight(20);
        distance.setPrefWidth(838);
        mainVbox.getChildren().add(distance);
    }
}
