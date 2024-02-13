package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class BookController {
    private Stage stage;
    private Long number;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView imgB,logobtn,cartbtn,profilebtn;
    @FXML
    private Button addB,classicbtn, historybtn, biobtn, psychobtn, cookingbtn, scifibtn;
    @FXML
    private Label nameB,authorB,publisherB,priceB;
    @FXML
    private Text descriptionB;
    public int uId = SignInController.loggedInUserId;
    public String bId = HelloController.clickedBook;
    public String BID = HelloController.searchedBook;
    public void initialize() throws IOException {
        if (bId != null){
            BufferedReader reader1= new BufferedReader(new FileReader("Files/Books.txt"));
            String line;
            while ((line= reader1.readLine())!=null&& !Objects.equals(line.split("#")[1], bId)){
            }
            reader1.close();
            priceB.setText(line.split("#")[3]+" تومان");
            nameB.setText(line.split("#")[4]);
            authorB.setText(line.split("#")[5]);
            publisherB.setText(line.split("#")[6]);
            descriptionB.setText(line.split("#")[7]);
            Image image = new Image(getClass().getResource(bId+".jpg").toExternalForm());
            imgB.setImage(image);
            if (uId!=100) {
                BufferedReader reader2 = new BufferedReader(new FileReader("Files/Cart.txt"));
                while ((line = reader2.readLine()) != null && !Objects.equals(line.split("#")[1], String.valueOf(uId))) {
                }
                reader2.close();
                for (int i = 2; i < Objects.requireNonNull(line).split("#").length; i+=2) {
                    if (Objects.equals(bId, line.split("#")[i])) {
                        addB.setText("افزوده شد");
                        addB.setDisable(true);
                    }
                }
            }
            BufferedReader reader3 = new BufferedReader(new FileReader("Files/Books.txt"));
            while ((line = reader3.readLine()) != null && !Objects.equals(line.split("#")[1], bId)) {
            }
            if (Objects.equals(line.split("#")[2], "0")) {
                priceB.setText("ناموجود");
                priceB.setTextFill(Color.RED);
                addB.setDisable(true);
            }
            reader3.close();
        } else if (BID != null) {
            BufferedReader reader1= new BufferedReader(new FileReader("Files/Books.txt"));
            String line;
            while ((line= reader1.readLine())!=null&& !Objects.equals(line.split("#")[1], BID)){
            }
            reader1.close();
            priceB.setText(line.split("#")[3]+" تومان");
            nameB.setText(line.split("#")[4]);
            authorB.setText(line.split("#")[5]);
            publisherB.setText(line.split("#")[6]);
            descriptionB.setText(line.split("#")[7]);
            Image image = new Image(getClass().getResource(BID+".jpg").toExternalForm());
            imgB.setImage(image);
            if (uId!=100) {
                BufferedReader reader2 = new BufferedReader(new FileReader("Files/Cart.txt"));
                while ((line = reader2.readLine()) != null && !Objects.equals(line.split("#")[1], String.valueOf(uId))) {
                }
                reader2.close();
                for (int i = 2; i < Objects.requireNonNull(line).split("#").length; i+=2) {
                    if (Objects.equals(BID, line.split("#")[i])) {
                        addB.setText("افزوده شد");
                        addB.setDisable(true);
                    }
                }
            }
            BufferedReader reader3 = new BufferedReader(new FileReader("Files/Books.txt"));
            while ((line = reader3.readLine()) != null && !Objects.equals(line.split("#")[1], BID)) {
            }
            if (Objects.equals(line.split("#")[2], "0")) {
                priceB.setText("ناموجود");
                priceB.setTextFill(Color.RED);
                addB.setDisable(true);
            }
            reader3.close();
        }
    }
    @FXML
    private void onAddBClicked(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            stage.centerOnScreen();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine()) != null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))) {
                ordersText.append(read + "\n");
            }
            ordersText.append(read + bId + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            addB.setText("افزوده شد");
            addB.setDisable(true);
        }
    }
    @FXML
    void onUserClicked(MouseEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            stage.centerOnScreen();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("UserPanel.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            stage.centerOnScreen();
        }
    }

    @FXML
    void onCartClicked(MouseEvent event) throws IOException {
        if (uId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            stage.centerOnScreen();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            stage.centerOnScreen();
        }
    }

    @FXML
    void onLogoClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onClassicClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("classicbooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onHistoryClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("historybooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onBioClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("biobooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onPsychoClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("psychobooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onCookingClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cookingbooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onScifiClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scifibooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }
}
/*
* BufferedReader reader1= new BufferedReader(new FileReader("Files/Books.txt"));
        String line;
        while ((line= reader1.readLine())!=null&& !Objects.equals(line.split("#")[1], bId)){
        }
        reader1.close();
        priceB.setText(line.split("#")[3]+" تومان");
        nameB.setText(line.split("#")[4]);
        authorB.setText(line.split("#")[5]);
        publisherB.setText(line.split("#")[6]);
        descriptionB.setText(line.split("#")[7]);
        Image image = new Image(getClass().getResource(bId+".jpg").toExternalForm());
        imgB.setImage(image);
        if (uId!=100) {
            BufferedReader reader2 = new BufferedReader(new FileReader("Files/Cart.txt"));
            while ((line = reader2.readLine()) != null && !Objects.equals(line.split("#")[1], String.valueOf(uId))) {
            }
            reader2.close();
            for (int i = 2; i < Objects.requireNonNull(line).split("#").length; i+=2) {
                if (Objects.equals(bId, line.split("#")[i])) {
                    addB.setText("افزوده شد");
                    addB.setDisable(true);
                }
            }
        }
        BufferedReader reader3 = new BufferedReader(new FileReader("Files/Books.txt"));
        while ((line = reader3.readLine()) != null && !Objects.equals(line.split("#")[1], bId)) {
        }
        if (Objects.equals(line.split("#")[2], "0")) {
            priceB.setText("ناموجود");
            priceB.setTextFill(Color.RED);
            addB.setDisable(true);
        }
        reader3.close();
* */
