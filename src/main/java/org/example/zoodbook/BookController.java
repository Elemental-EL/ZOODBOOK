package org.example.zoodbook;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;

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
}
