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
    private ImageView backbtn,logobtn;
    @FXML
    private VBox ordersVBox;

    public void initialize() throws IOException, NoSuchFieldException, IllegalAccessException{
        String[] orderBooksID = new String[48];
        String[] orderBooksQuantity = new String[48];
        String[] orderBooksName= new String[48];
        String[] orderBooksPrice = new String[48];
        if (SignInController.loggedInUserId!=100){
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            String read;
            while (((read = reader.readLine()) != null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
            }
            for (int i = 0; i<(read.split("#").length-1)/2 ; i++){
                int k = (2*i)+2;
                orderBooksID[i] = read.split("#")[k];
                orderBooksQuantity[i] = read.split("#")[k+1];
            }
            reader.close();
            for (int i = 0 ; i<48 && orderBooksID[i] != null ; i++){
                BufferedReader reader1 = new BufferedReader(new FileReader("Files/Books.txt"));
                String line1;
                while (((line1 = reader1.readLine())!=null) && (!Objects.equals(line1.split("#")[1], orderBooksID[i]))){
                }
                orderBooksName[i] = line1.split("#")[4];
                orderBooksPrice[i] = line1.split("#")[3];
            }
            newOrder(orderBooksName , orderBooksQuantity , orderBooksPrice , orderBooksID);
        }else {
        }
//        BufferedReader reader1 = new BufferedReader(new FileReader("Files/Cart.txt"));
//        StringBuilder line = new StringBuilder();
//        String line2;
//        while (((line2 = reader1.readLine())!=null) && (!Objects.equals(line2.split("#")[1], String.valueOf(SignInController.loggedInUserId)))){
//            line.append(line2);
//        }
    }

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
    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void onContinueShoppingClicked(ActionEvent actionEvent) {
        setOrdersVBox(ordersVBox);

    }
    public void setOrdersVBox(VBox ordersVBox) {
        ordersVBox.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }
    public List<String> getOrdersByUserId (){

        List<String> userOrders = new ArrayList<>();
        //Get from file
        return userOrders;
    }
    public void newOrder(String[] a , String[] b , String[] c , String[] d){
        for (int i=0 ; i<48 && a[i] != null ; i++){
            BorderPane newPane =  new BorderPane();
            Label bookName = new Label("نام کتاب :");
            Label quantity = new Label("تعداد :");
            Label bookPrice = new Label("قیمت :");
            TextField orderBookName = new TextField(a[i]);
            orderBookName.setEditable(false);
            TextField orderBookQuantity = new TextField(b[i]);
            orderBookQuantity.setEditable(false);
            TextField orderBookPrice = new TextField(String.valueOf(Long.parseLong(b[i])*Long.parseLong(c[i])));
            orderBookPrice.setEditable(false);
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
            orderBookName.getStyleClass().addAll("orders-txtField" , "order-orderBookName");
            orderBookQuantity.getStyleClass().addAll("orders-txtField" , "order-orderBookQuantity");
            orderBookPrice.getStyleClass().addAll("orders-txtField" , "order-orderBookPrice");
            add.getStyleClass().addAll("order-add-reduce-btn" , "zoom" , "mainpageElementsdarkgreen");
            reduce.getStyleClass().addAll("order-add-reduce-btn" , "zoom" , "mainpageElementsdarkgreen");
            del.setFitHeight(25);
            del.setFitWidth(25);
            delete.getStyleClass().addAll("order-add-reduce-btn","zoom" , "lightgreen");

            orderHBox.getChildren().addAll(delete , reduce , add , orderBookPrice , bookPrice , orderBookQuantity , quantity , orderBookName , bookName);
            newPane.setRight(orderHBox);
            ordersVBox.getChildren().add(newPane);
            int finalI = i;
            add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    number = Long.valueOf(b[finalI]);
                    number++;
                    orderBookQuantity.setText(String.valueOf(number));
                    b[finalI] = String.valueOf(number);
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
                        StringBuilder lines = new StringBuilder();
                        String line;
                        StringBuilder line1 = new StringBuilder("#" + SignInController.loggedInUserId + "#");
                        while (((line = reader.readLine())!=null) && (!String.valueOf(SignInController.loggedInUserId).equals(line.split("#")[1]))){
                            lines.append(line + "\n");
                        }
                        for (int j=0 ; j<(line.split("#").length-1)/2 ; j++){
                            line1.append(d[j]+ "#" + b[j] + "#");
                        }
                        lines.append(line1 + "\n");
                        while ((line = reader.readLine())!=null){
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
                    orderBookPrice.setText(String.valueOf(Long.valueOf(b[finalI])*Long.valueOf(c[finalI])));
                }
            });
            reduce.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (Long.parseLong(orderBookQuantity.getText())>1){
                        number = Long.valueOf(b[finalI]);
                        number--;
                        orderBookQuantity.setText(String.valueOf(number));
                        b[finalI] = String.valueOf(number);
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
                            StringBuilder lines = new StringBuilder();
                            String line;
                            StringBuilder line1 = new StringBuilder("#" + SignInController.loggedInUserId + "#");
                            while (((line = reader.readLine())!=null) && (!String.valueOf(SignInController.loggedInUserId).equals(line.split("#")[1]))){
                                lines.append(line + "\n");
                            }
                            for (int j=0 ; j<(line.split("#").length-1)/2 ; j++){
                                line1.append(d[j]+ "#" + b[j] + "#");
                            }
                            lines.append(line1 + "\n");
                            while ((line = reader.readLine())!=null){
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
                        orderBookPrice.setText(String.valueOf(Long.valueOf(b[finalI])*Long.valueOf(c[finalI])));
                    }
                }
            });
            delete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    newPane.getChildren().remove(orderHBox);
                    for (int j = finalI ; j<a.length-1 ; j++){
                        a[j] = a[j+1];
                        b[j] = b[j+1];
                        c[j] = c[j+1];
                        d[j] = d[j+1];
                    }
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
                        StringBuilder lines = new StringBuilder();
                        String line;
                        StringBuilder line1 = new StringBuilder("#" + SignInController.loggedInUserId + "#");
                        while (((line = reader.readLine())!=null) && (!String.valueOf(SignInController.loggedInUserId).equals(line.split("#")[1]))){
                            lines.append(line + "\n");
                        }
                        for (int k=0 ; k<(line.split("#").length-3)/2 ; k++){
                            line1.append(d[k]+ "#" + b[k] + "#");
                        }
                        lines.append(line1 + "\n");
                        while ((line = reader.readLine())!=null){
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
                }
            });
        }
    }
}
