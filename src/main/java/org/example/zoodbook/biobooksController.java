package org.example.zoodbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class biobooksController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button jumpUpbtn, classicbtn, historybtn, biobtn, psychobtn, cookingbtn, scifibtn, add1, add2, add3, add4, add5, add6, add7, add8;
    @FXML
    private Label price1, price2, price3, price4, price5, price6, price7, price8;
    @FXML
    private ImageView profilebtn, cartbtn, logobtn;
    public int uId = SignInController.loggedInUserId;

    public void initialize() throws IOException, NoSuchFieldException, IllegalAccessException {
        if (uId != 100) {
            Map<String, Button> productButtonMap = new HashMap<>();
            for (int i = 1; i < 9; i++) {
                String buttonId = "add" + i;
                Button button = (Button) getClass().getDeclaredField(buttonId).get(this);
                productButtonMap.put("b" + i, button);
            }
            BufferedReader reader0 = new BufferedReader(new FileReader("Files/Cart.txt"));
            String line;
            while ((line = reader0.readLine()) != null && !Objects.equals(line.split("#")[1], String.valueOf(uId))) {
            }
            for (int i = 2; i < Objects.requireNonNull(line).split("#").length; i += 2) {
                Button buttonToDisable = productButtonMap.get(line.split("#")[i]);
                if (buttonToDisable != null) {
                    buttonToDisable.setDisable(true);
                    buttonToDisable.setText("افزوده شد");
                }
            }
            reader0.close();
        }
        BufferedReader reader = new BufferedReader(new FileReader("Files/Books.txt"));
        String line;
        int i = 1;
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "h8")) {
        }
        while ((line = reader.readLine()) != null && !Objects.equals(line.split("#")[1], "p1")) {
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
        while (i < 9) {
            Label price = (Label) getClass().getDeclaredField("price" + i).get(this);
            Button add = (Button) getClass().getDeclaredField("add" + i).get(this);
            if (Objects.equals(price.getText(), "ناموجود"))
                add.setDisable(true);
            i++;
        }
    }

    @FXML
    void onUserClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
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
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
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
    }

    @FXML
    void onClassicClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("classicbooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void onHistoryClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("historybooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void onBioClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("biobooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void onPsychoClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("psychobooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void onCookingClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cookingbooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void onScifiClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scifibooks.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void onJumpUpClicked(ActionEvent event) {
        scrollPane.setVvalue(0);
    }

    @FXML
    void onAdd1(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
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
            add1.setText("افزوده شد");
            add1.setDisable(true);
        }
    }

    @FXML
    void onAdd2(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
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
            add2.setText("افزوده شد");
            add2.setDisable(true);
        }
    }

    @FXML
    void onAdd3(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
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
            add3.setText("افزوده شد");
            add3.setDisable(true);
        }
    }

    @FXML
    void onAdd4(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
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
            add4.setText("افزوده شد");
            add4.setDisable(true);
        }
    }

    @FXML
    void onAdd5(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine()) != null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))) {
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "b5" + "#" + "1" + "#" + "\n");
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

    @FXML
    void onAdd6(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine()) != null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))) {
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "b6" + "#" + "1" + "#" + "\n");
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

    @FXML
    void onAdd7(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine()) != null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))) {
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "b7" + "#" + "1" + "#" + "\n");
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

    @FXML
    void onAdd8(ActionEvent event) throws IOException {
        if (SignInController.loggedInUserId == 100) {
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader("Files/Cart.txt"));
            StringBuilder ordersText = new StringBuilder();
            String read;
            while (((read = reader.readLine()) != null) && (!Objects.equals(read.split("#")[1], String.valueOf(SignInController.loggedInUserId)))) {
                ordersText.append(read + "\n");
            }
            ordersText.append(read + "b8" + "#" + "1" + "#" + "\n");
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
}
