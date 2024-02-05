package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class PaymentDetailsController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView backbtn, logobtn;
    @FXML
    private Text shippingBooks, shippingPrice, totalPrice;
    @FXML
    private Button purchasebtn;
    public int uId;

    public void initialize() throws IOException{
        uId = SignInController.loggedInUserId;
        shippingBooks.setText(CartController.totalPrice +" تومان");
        shippingPrice.setText((long) (CartController.totalPrice * 0.15) +" تومان");
        totalPrice.setText(CartController.totalPrice +(long) (CartController.totalPrice * 0.15) +" تومان");
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

    @FXML
    public void onBackClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onPurchaseClicked(ActionEvent event) throws IOException {
        String lastOrderID="1001";
        String line, orders="";
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = dateFormat.format(currentDate);
        StringBuilder orderText = new StringBuilder();
        StringBuilder newCart = new StringBuilder();
        BufferedReader reader1 = new BufferedReader(new FileReader("Files/Orders.txt"));
        while ((line = reader1.readLine()) != null)
            lastOrderID = line.split("#")[2];
        reader1.close();
        int newId = Integer.parseInt(lastOrderID);
        newId++;
        BufferedReader reader2 = new BufferedReader(new FileReader("Files/Orders.txt"));
        while ((line = reader2.readLine()) != null)
            orderText.append(line + "\n");
        reader2.close();
        BufferedReader reader3 = new BufferedReader(new FileReader("Files/Cart.txt"));
        while ((line = reader3.readLine())!=null&& !Objects.equals(line.split("#")[1], String.valueOf(uId))){
            newCart.append(line + "\n");
        }
        newCart.append("#"+line.split("#")[1]+"#"+"\n");
        for (int i=2;i<line.split("#").length;i++)
            orders+=line.split("#")[i]+"#";
        while ((line = reader3.readLine())!=null){
            newCart.append(line + "\n");
        }
        reader3.close();
        String newOrder="#"+uId+"#"+newId+"#"+formattedDate+"#"+totalPrice.getText().replaceAll("\\D", "")+"#"+0+"#"+orders;
        orderText.append(newOrder + "\n");
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("Files/Orders.txt"));
        writer1.write(String.valueOf(orderText));
        writer1.close();
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("Files/Cart.txt"));
        writer2.write(String.valueOf(newCart));
        writer2.close();
        String[] BooksID = new String[48];
        String[] BooksQuantity = new String[48];
        String[] BooksPrice = new String[48];
        String[] BooksName = new String[48];
        String[] BooksAuthor = new String[48];
        String[] BooksPublisher = new String[48];
        String[] BooksDescription = new String[48];
        BufferedReader reader4 = new BufferedReader(new FileReader("Files/Books.txt"));
        StringBuilder newStorage = new StringBuilder();
        for (int i = 0; i<48;i++) {
            line = reader4.readLine();
            BooksID[i] = line.split("#")[1];
            BooksQuantity[i] = line.split("#")[2];
            BooksPrice[i] = line.split("#")[3];
            BooksName[i] = line.split("#")[4];
            BooksAuthor[i] = line.split("#")[5];
            BooksPublisher[i] = line.split("#")[6];
            BooksDescription[i] = line.split("#")[7];
        }
        reader4.close();
        for (int i = 6;i<newOrder.split("#").length-1;i+=2){
            for (int j = 0;j<48;j++){
                if (Objects.equals(newOrder.split("#")[i], BooksID[j])){
                    int a = Integer.parseInt(BooksQuantity[j]);
                    int b = Integer.parseInt(newOrder.split("#")[i+1]);
                    a-=b;
                    BooksQuantity[j] = String.valueOf(a);
                }
            }
        }
        for (int i=0;i<48;i++){
            newStorage.append("#"+BooksID[i]+"#"+BooksQuantity[i]+"#"+BooksPrice[i]+"#"+BooksName[i]+"#"+BooksAuthor[i]+"#"+BooksPublisher[i]+"#"+BooksDescription[i]+"#"+"\n");
        }
        BufferedWriter writer3 = new BufferedWriter(new FileWriter("Files/Books.txt"));
        writer3.write(String.valueOf(newStorage));
        writer3.close();
        Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
}
