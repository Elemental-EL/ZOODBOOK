package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartController {
    private Stage stage;
    private Long number;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView backbtn, logobtn;
    @FXML
    private VBox ordersVBox;
    public static long totalPrice;
    @FXML
    private VBox ordersVbox1;

    public void initialize() throws IOException, NoSuchFieldException, IllegalAccessException {
        ordersVBox.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        String[] orderBooksID = new String[48];
        String[] orderBooksQuantity = new String[48];
        String[] orderBooksName = new String[48];
        String[] orderBooksPrice = new String[48];
        if (SignInController.loggedInUserId != 100) {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            String read;
            while (((read = reader.readLine()) != null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))) {
            }
            for (int i = 0; i < (read.split("#").length - 1) / 2; i++) {
                int k = (2 * i) + 2;
                orderBooksID[i] = read.split("#")[k];
                orderBooksQuantity[i] = read.split("#")[k + 1];
            }
            reader.close();
            totalPrice=0;
            for (int i = 0; i < 48 && orderBooksID[i] != null; i++) {
                BufferedReader reader1 = new BufferedReader(new FileReader("Files/Books.txt"));
                String line1;
                while (((line1 = reader1.readLine()) != null) && (!Objects.equals(line1.split("#")[1], orderBooksID[i]))) {
                }
                orderBooksName[i] = line1.split("#")[4];
                orderBooksPrice[i] = line1.split("#")[3];
            }
            newOrder(orderBooksName, orderBooksQuantity, orderBooksPrice, orderBooksID);
            reader.close();
            BufferedReader reader1 = new BufferedReader(new FileReader("Files/Orders.txt"));
            String line;
            while (((line = reader1.readLine())!=null)){
                if (Objects.equals(line.split("#")[1], String.valueOf(SignInController.loggedInUserId))){
                    updateOrders(line);
                }
            }
            reader1.close();
        }
    }

    public void onLogoClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    public void onContinueShoppingClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Payment Details.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    public void newOrder(String[] orderBooksName, String[] orderBooksQuantity, String[] orderBooksPrice, String[] orderBooksID) throws IOException {
        for (int i = 0; i < 48 && orderBooksName[i] != null; i++) {
            BorderPane newPane = new BorderPane();
            Label bookName = new Label("نام کتاب :");
            Label quantity = new Label("تعداد :");
            Label bookPrice = new Label("قیمت :");
            TextField orderBookName = new TextField(orderBooksName[i]);
            orderBookName.setEditable(false);
            TextField orderBookQuantity = new TextField(orderBooksQuantity[i]);
            orderBookQuantity.setEditable(false);
            TextField orderBookPrice = new TextField(String.valueOf(Long.parseLong(orderBooksQuantity[i]) * Long.parseLong(orderBooksPrice[i])));
            orderBookPrice.setEditable(false);
            totalPrice+=(Long.parseLong(orderBookPrice.getText()));
            Button add = new Button("+");
            Button reduce = new Button("-");
            Image image = new Image(getClass().getResourceAsStream("recycle-bin.png"));
            ImageView del = new ImageView();
            del.setImage(image);
            Button delete = new Button();
            delete.setGraphic(del);
            HBox orderHBox = new HBox(9);

            bookName.getStyleClass().add("orderBooksLabel");
            quantity.getStyleClass().add("orderBooksLabel");
            bookPrice.getStyleClass().add("orderBooksLabel");
            orderHBox.getStyleClass().add("orderHBox");
            orderBookName.getStyleClass().addAll("orders-txtField", "order-orderBookName");
            orderBookQuantity.getStyleClass().addAll("orders-txtField", "order-orderBookQuantity");
            orderBookPrice.getStyleClass().addAll("orders-txtField", "order-orderBookPrice");
            add.getStyleClass().addAll("order-add-reduce-btn", "zoom", "mainpageElementsdarkgreen");
            reduce.getStyleClass().addAll("order-add-reduce-btn", "zoom", "mainpageElementsdarkgreen");
            del.setFitHeight(25);
            del.setFitWidth(25);
            delete.getStyleClass().addAll("order-add-reduce-btn", "zoom", "lightgreen");

            orderHBox.getChildren().addAll(delete, reduce, add, orderBookPrice, bookPrice, orderBookQuantity, quantity, orderBookName, bookName);
            newPane.setRight(orderHBox);
            ordersVBox.getChildren().add(newPane);
            int finalI = i;
            add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    number = Long.valueOf(orderBooksQuantity[finalI]);
                    number++;
                    orderBookQuantity.setText(String.valueOf(number));
                    orderBooksQuantity[finalI] = String.valueOf(number);
                    totalPrice+=Long.parseLong(orderBooksPrice[finalI]);
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
                        StringBuilder lines = new StringBuilder();
                        String line;
                        StringBuilder line1 = new StringBuilder("#" + SignInController.loggedInUserId + "#");
                        while (((line = reader.readLine()) != null) && (!String.valueOf(SignInController.loggedInUserId).equals(line.split("#")[1]))) {
                            lines.append(line + "\n");
                        }
                        for (int j = 0; j < (line.split("#").length - 2) / 2; j++) {
                            line1.append(orderBooksID[j] + "#" + orderBooksQuantity[j] + "#");
                        }
                        lines.append(line1 + "\n");
                        while ((line = reader.readLine()) != null) {
                            lines.append(line + "\n");
                        }
                        reader.close();
                        BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
                        writer.write(String.valueOf(lines));
                        writer.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    orderBookPrice.setText(String.valueOf(Long.valueOf(orderBooksQuantity[finalI]) * Long.valueOf(orderBooksPrice[finalI])));
                }
            });
            reduce.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (Long.parseLong(orderBookQuantity.getText()) > 1) {
                        number = Long.valueOf(orderBooksQuantity[finalI]);
                        number--;
                        orderBookQuantity.setText(String.valueOf(number));
                        orderBooksQuantity[finalI] = String.valueOf(number);
                        totalPrice-=Long.parseLong(orderBooksPrice[finalI]);
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
                            StringBuilder lines = new StringBuilder();
                            String line;
                            StringBuilder line1 = new StringBuilder("#" + SignInController.loggedInUserId + "#");
                            while (((line = reader.readLine()) != null) && (!String.valueOf(SignInController.loggedInUserId).equals(line.split("#")[1]))) {
                                lines.append(line + "\n");
                            }
                            for (int j = 0; j < (line.split("#").length - 2) / 2; j++) {
                                line1.append(orderBooksID[j] + "#" + orderBooksQuantity[j] + "#");
                            }
                            lines.append(line1 + "\n");
                            while ((line = reader.readLine()) != null) {
                                lines.append(line + "\n");
                            }
                            reader.close();
                            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
                            writer.write(String.valueOf(lines));
                            writer.close();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        orderBookPrice.setText(String.valueOf(Long.parseLong(orderBooksQuantity[finalI]) * Long.parseLong(orderBooksPrice[finalI])));
                    }
                }
            });
            delete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    int lengh = orderBooksName.length - 1;
                    for (int j = finalI; j < lengh; j++) {
                        orderBooksName[j] = orderBooksName[j + 1];
                        orderBooksQuantity[j] = orderBooksQuantity[j + 1];
                        orderBooksPrice[j] = orderBooksPrice[j + 1];
                        orderBooksID[j] = orderBooksID[j + 1];
                    }
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
                        StringBuilder lines = new StringBuilder();
                        String line;
                        StringBuilder line1 = new StringBuilder("#" + SignInController.loggedInUserId + "#");
                        while (((line = reader.readLine()) != null) && (!String.valueOf(SignInController.loggedInUserId).equals(line.split("#")[1]))) {
                            lines.append(line + "\n");
                        }
                        for (int k = 0; k < (line.split("#").length - 3) / 2; k++) {
                            line1.append(orderBooksID[k] + "#" + orderBooksQuantity[k] + "#");
                        }
                        lines.append(line1 + "\n");
                        while ((line = reader.readLine()) != null) {
                            lines.append(line + "\n");
                        }
                        reader.close();
                        BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
                        writer.write(String.valueOf(lines));
                        writer.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        ordersVBox.getChildren().clear();
                        initialize();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchFieldException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
    public void updateOrders(String line) throws IOException {
        String[] orderBooksID1 = new String[48];
        String[] orderBooksQuantity1 = new String[48];
        String[] orderBooksName1 = new String[48];
        String status;
        if (Integer.parseInt(line.split("#")[5])==0){
            status = "جاری";
        }else {
            status = "ارسال شده";
        }
        Label orderBooksCode = new Label("کد پیگیری سفارش :");
        TextField orderBooksCode1 = new TextField(line.split("#")[2]);
        Label orderStatus = new Label("وضعیت :");
        TextField orderbookStatus = new TextField(status);
        orderBooksCode1.setStyle("-fx-pref-width: 75");
        orderStatus.setStyle("-fx-padding: 0 20 0 10");
        orderBooksCode.getStyleClass().add("orderBooksLabel");
        orderStatus.getStyleClass().add("orderBooksLabel");
        orderBooksCode1.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        orderbookStatus.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        orderBooksCode1.setEditable(false);
        orderbookStatus.setEditable(false);
        HBox firstDate = new HBox(4);
        firstDate.getChildren().addAll(orderbookStatus , orderStatus , orderBooksCode1 , orderBooksCode);
        BorderPane firstPane = new BorderPane();
        firstPane.setRight(firstDate);
        firstPane.setStyle("-fx-padding: 10");
        ordersVbox1.getChildren().add(firstPane);
        for (int i=0 ; i<((line.split("#").length)-6)/2 ; i++){
            orderBooksID1[i] = line.split("#")[2*i+6];
            orderBooksQuantity1[i] = line.split("#")[2*i+7];
        }
        for (int i=0 ; i<orderBooksID1.length && orderBooksID1[i]!=null ; i++){
            BufferedReader reader1 = new BufferedReader(new FileReader("Files/Books.txt"));
            String line1;
            while (((line1 = reader1.readLine())!=null) && ((!Objects.equals(line1.split("#")[1], orderBooksID1[i]))) ){
            }
            orderBooksName1[i] = line1.split("#")[4];
        }
        for (int j = 0 ; j<orderBooksID1.length && orderBooksID1[j]!=null; j++){
            HBox secondHbox = new HBox(4);
            Label bookname = new Label("نام کتاب :");
            TextField booksName = new TextField(orderBooksName1[j]);
            bookname.getStyleClass().add("orderBooksLabel");
            bookname.setStyle("-fx-padding: 0 20 0 5");
            booksName.getStyleClass().addAll("orders-txtField", "order-orderBookName");
            booksName.setEditable(false);
            Label bookquantity = new Label("تعداد : ");
            TextField bookQuantity = new TextField(orderBooksQuantity1[j]);
            bookquantity.getStyleClass().add("orderBooksLabel");
            bookQuantity.getStyleClass().addAll("orders-txtField", "order-orderBookQuantity");
            bookquantity.setStyle("-fx-padding: 0 20 0 5");
            bookQuantity.setEditable(false);
            HBox hBox = new HBox(4);
            hBox.getChildren().addAll(bookQuantity , bookquantity , booksName , bookname);
            BorderPane ordersPane = new BorderPane();
            ordersPane.setStyle("-fx-padding: 5");
            ordersPane.setRight(hBox);
            ordersVbox1.getChildren().add(ordersPane);
        }
        Label orderBooksDate = new Label("تاریخ ثبت سفارش :");
        TextField orderBooksDate1 = new TextField(line.split("#")[3]);
        Label orderprice = new Label("مبلغ پرداخت شده :");
        TextField orderPrice = new TextField(line.split("#")[4]);
        orderBooksDate.getStyleClass().add("orderBooksLabel");
        orderprice.getStyleClass().add("orderBooksLabel");
        orderprice.setStyle("-fx-padding: 0 20 0 5");
        orderPrice.setStyle("-fx-pref-width: 100");
        orderBooksDate1.setStyle("-fx-pref-width: 100");
        orderBooksDate1.setEditable(false);
        orderPrice.setEditable(false);
        orderBooksDate1.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        orderPrice.getStyleClass().addAll("orders-txtField", "order-orderBookName");
        HBox hbox1 = new HBox(4);
        hbox1.getChildren().addAll(orderPrice , orderprice , orderBooksDate1 , orderBooksDate);
        BorderPane lastborderpane = new BorderPane();
        lastborderpane.setStyle("-fx-padding: 5");
        lastborderpane.setRight(hbox1);
        ordersVbox1.getChildren().add(lastborderpane);
    }
}
//    public void update() throws IOException {
//        String[] orderBooksID = new String[48];
//        String[] orderBooksQuantity = new String[48];
//        String[] orderBooksName = new String[48];
//        String[] orderBooksPrice = new String[48];
//        if (SignInController.loggedInUserId != 100) {
//            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
//            String read;
//            while (((read = reader.readLine()) != null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))) {
//            }
//            for (int i = 0; i < (read.split("#").length - 1) / 2; i++) {
//                int k = (2 * i) + 2;
//                orderBooksID[i] = read.split("#")[k];
//                orderBooksQuantity[i] = read.split("#")[k + 1];
//            }
//            reader.close();
//            for (int i = 0; i < 48 && orderBooksID[i] != null; i++) {
//                BufferedReader reader1 = new BufferedReader(new FileReader("Files/Books.txt"));
//                String line1;
//                while (((line1 = reader1.readLine()) != null) && (!Objects.equals(line1.split("#")[1], orderBooksID[i]))) {
//                }
//                orderBooksName[i] = line1.split("#")[4];
//                orderBooksPrice[i] = line1.split("#")[3];
//            }
//        }
//    }
