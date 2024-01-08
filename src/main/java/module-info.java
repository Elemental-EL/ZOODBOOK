module org.example.zoodbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.zoodbook to javafx.fxml;
    exports org.example.zoodbook;
}