package org.example.zoodbook;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Objects;


public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button jumpUpbtn, classicbtn, historybtn, biobtn, psychobtn, cookingbtn, scifibtn, showMoreCl, showMoreHis, showMoreBio, showMorePsycho, showMoreCooking, showMoreScifi, add1, add2, add3, add4, add5, add6, add7, add8, add9, add10, add11, add12, add13, add14, add15, add16, add17, add18, add19, add20, add21, add22, add23, add24;
    @FXML
    private TextField searchBar;
    @FXML
    private ImageView profilebtn, cartbtn, searchbtn, logobtn;
    @FXML
    private Label price1, price2, price, price3, price4, price5, price6, price7, price8, price9, price10, price11, price12, price13, price14, price15, price16, price17, price18, price19, price20, price21, price22, price23, price24;
    @FXML
    private Hyperlink link;
    @FXML
    private ScrollPane scrollPane;
    public int uId = SignInController.loggedInUserId;
    public static String clickedBook;
    public void initialize() throws IOException, NoSuchFieldException, IllegalAccessException {
        if (uId != 100) {
            Map<String, Button> productButtonMap = new HashMap<>();
            int i = 1;
            while (i < 5) {
                String buttonId = "add" + i;
                Button button = (Button) getClass().getDeclaredField(buttonId).get(this);
                productButtonMap.put("cl" + i, button);
                i++;
            }
            int j = 1;
            while (j < 5) {
                String buttonId = "add" + i;
                Button button = (Button) getClass().getDeclaredField(buttonId).get(this);
                productButtonMap.put("h" + j, button);
                i++;
                j++;
            }
            j = 1;
            while (j < 5) {
                String buttonId = "add" + i;
                Button button = (Button) getClass().getDeclaredField(buttonId).get(this);
                productButtonMap.put("b" + j, button);
                i++;
                j++;
            }
            j = 1;
            while (j < 5) {
                String buttonId = "add" + i;
                Button button = (Button) getClass().getDeclaredField(buttonId).get(this);
                productButtonMap.put("p" + j, button);
                i++;
                j++;
            }
            j = 1;
            while (j < 5) {
                String buttonId = "add" + i;
                Button button = (Button) getClass().getDeclaredField(buttonId).get(this);
                productButtonMap.put("co" + j, button);
                i++;
                j++;
            }
            j = 1;
            while (j < 5) {
                String buttonId = "add" + i;
                Button button = (Button) getClass().getDeclaredField(buttonId).get(this);
                productButtonMap.put("s" + j, button);
                i++;
                j++;
            }
            BufferedReader reader0 = new BufferedReader(new FileReader("Files/Cart.txt"));
            String line;
            while ((line = reader0.readLine()) != null && !Objects.equals(line.split("#")[1], String.valueOf(uId))) {
            }
            for (i = 2; i < Objects.requireNonNull(line).split("#").length; i += 2) {
                Button buttonToDisable = productButtonMap.get(line.split("#")[i]);
                if (buttonToDisable != null) {
                    buttonToDisable.setDisable(true);
                    buttonToDisable.setText("افزوده شد");
                } else {
                    System.out.println("Button not found for string: " + line.split("#")[i]);
                }
            }
            reader0.close();
        }
        BufferedReader reader = new BufferedReader(new FileReader("Files/Books.txt"));
        String line = "";
        int i = 1;
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "cl5")) {
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            } else
                price.setText(line.split("#")[3] + " تومان");
            i++;
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "cl8")) ;
        {
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "h5")) {
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            } else
                price.setText(line.split("#")[3] + " تومان");
            i++;
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "h8")) ;
        {
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "b5")) {
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            } else
                price.setText(line.split("#")[3] + " تومان");
            i++;
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "b8")) ;
        {
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "p5")) {
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            } else
                price.setText(line.split("#")[3] + " تومان");
            i++;
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "p8")) ;
        {
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "co5")) {
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            } else
                price.setText(line.split("#")[3] + " تومان");
            i++;
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "co8")) ;
        {
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "s5")) {
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            if (Objects.equals(line.split("#")[2], "0")) {
                price.setText("ناموجود");
                price.setTextFill(Color.RED);
            } else
                price.setText(line.split("#")[3] + " تومان");
            i++;
        }
        reader.close();
        i = 1;
        while (i < 25) {
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            Button add = (Button) getClass().getDeclaredField("add" + i).get(this);
            if (Objects.equals(price.getText(), "ناموجود"))
                add.setDisable(true);
            i++;
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
    void onLogoClicked(MouseEvent event) {

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

    @FXML
    void onShowMoreClassic(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("classicbooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onShowMoreHistory(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("historybooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onShowMoreBio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("biobooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onShowMorePsycho(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("psychobooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onShowMoreCooking(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cooking.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onShowMoreScifi(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scifibooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onSearchClicked(MouseEvent event) {

    }

    @FXML
    void onShowMoreInfoClicked(ActionEvent event) throws URISyntaxException, IOException {

    }

    @FXML
    void onClassicLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("classicbooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onHistoryLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("historybooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onBioLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("biobooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onPsychoLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("psychobooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onCookingLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cookingbooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onScifiLinkClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scifibooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void onJumpUpClicked(ActionEvent event) {
        scrollPane.setVvalue(0);
    }


    public void onAdd1(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "cl1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add1.setText("افزوده شد");
            add1.setDisable(true);
        }
    }

    public void onAdd2(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "cl2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add2.setText("افزوده شد");
            add2.setDisable(true);
        }
    }

    public void onAdd3(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "cl3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add3.setText("افزوده شد");
            add3.setDisable(true);
        }

    }

    public void onAdd4(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "cl4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add4.setText("افزوده شد");
            add4.setDisable(true);
        }
    }

    public void onAdd5(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "h1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add5.setText("افزوده شد");
            add5.setDisable(true);
        }
    }

    public void onAdd6(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "h2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add6.setText("افزوده شد");
            add6.setDisable(true);
        }

    }

    public void onAdd7(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "h3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add7.setText("افزوده شد");
            add7.setDisable(true);
        }
    }

    public void onAdd8(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "h4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add8.setText("افزوده شد");
            add8.setDisable(true);
        }
    }

    public void onAdd9(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "b1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add9.setText("افزوده شد");
            add9.setDisable(true);
        }
    }

    public void onAdd10(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "b2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add10.setText("افزوده شد");
            add10.setDisable(true);
        }
    }

    public void onAdd11(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "b3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add11.setText("افزوده شد");
            add11.setDisable(true);
        }
    }

    public void onAdd12(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "b4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add12.setText("افزوده شد");
            add12.setDisable(true);
        }
    }

    public void onAdd13(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "p1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add13.setText("افزوده شد");
            add13.setDisable(true);
        }
    }

    public void onAdd14(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "p2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add14.setText("افزوده شد");
            add14.setDisable(true);
        }
    }

    public void onAdd15(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "p3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add15.setText("افزوده شد");
            add15.setDisable(true);
        }
    }

    public void onAdd16(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "p4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add16.setText("افزوده شد");
            add16.setDisable(true);
        }
    }

    public void onAdd17(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "co1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add17.setText("افزوده شد");
            add17.setDisable(true);
        }
    }

    public void onAdd18(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "co2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add18.setText("افزوده شد");
            add18.setDisable(true);
        }
    }

    public void onAdd19(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "co3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add19.setText("افزوده شد");
            add19.setDisable(true);
        }
    }

    public void onAdd20(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "co4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add20.setText("افزوده شد");
            add20.setDisable(true);
        }
    }

    public void onAdd21(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "s1" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add21.setText("افزوده شد");
            add21.setDisable(true);
        }
    }

    public void onAdd22(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "s2" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add22.setText("افزوده شد");
            add22.setDisable(true);
        }
    }

    public void onAdd23(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "s3" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add23.setText("افزوده شد");
            add23.setDisable(true);
        }
    }

    public void onAdd24(ActionEvent event) throws IOException {
        if (uId == 100) {
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
            ordersText.append(read + "s4" + "#" + "1" + "#" + "\n");
            while ((read = reader.readLine()) != null) {
                ordersText.append(read + "\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Cart.txt"));
            writer.write(String.valueOf(ordersText));
            writer.close();
            add24.setText("افزوده شد");
            add24.setDisable(true);
        }
    }
    @FXML
    private void onProductClicked(MouseEvent event) throws IOException {
        ImageView clickedImage = (ImageView) event.getSource();
        clickedBook = clickedImage.getImage().getUrl().substring(clickedImage.getImage().getUrl().lastIndexOf("/") + 1, clickedImage.getImage().getUrl().lastIndexOf("."));
        Parent root = FXMLLoader.load(getClass().getResource("Book.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }
    @FXML
    private HostServices hostServices;

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }
}

