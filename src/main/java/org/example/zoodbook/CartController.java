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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartController {
    private Stage stage;
    private Long number;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView backbtn,logobtn;
    @FXML
    private VBox ordersVBox;

    public void setOrdersVBox(VBox ordersVBox) {
        ordersVBox.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
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
    public void onBackClicked(MouseEvent event){

    }
    public void onContinueShoppingClicked(ActionEvent actionEvent) {
        setOrdersVBox(ordersVBox);
        for (int i=0 ; i<10 ; i++){
            newOrder();
        }
    }
    public List<String> getOrdersByUserId (){

        List<String> userOrders = new ArrayList<>();
        //Get from file
        return userOrders;
    }
    public void newOrder(){
        BorderPane newPane =  new BorderPane();
        Label bookName = new Label("نام کتاب :");
        Label quantity = new Label("تعداد :");
        Label bookPrice = new Label("قیمت :");
        TextField orderBookName = new TextField("");
        TextField orderBookQuantity = new TextField("0");
        TextField orderBookPrice = new TextField("");
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
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                number = Long.valueOf(orderBookQuantity.getText());
                number++;
                orderBookQuantity.setText(String.valueOf(number));
            }
        });
        reduce.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (Long.parseLong(orderBookQuantity.getText())>1){
                    number = Long.valueOf(orderBookQuantity.getText());
                    number--;
                    orderBookQuantity.setText(String.valueOf(number));
                } 
            }
        });
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newPane.getChildren().remove(orderHBox);
            }
        });
    }
}
