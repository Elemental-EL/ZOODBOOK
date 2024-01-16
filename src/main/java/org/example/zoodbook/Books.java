package org.example.zoodbook;

import javafx.scene.chart.LineChart;

public class Books {
    Long bookId;
    String bookName;
    int stQuantity;
    String price;

    Books(Long bookId , String bookName, int stQuantity , String price){
        this.bookId = bookId;
        this.bookName = bookName;
        this.stQuantity = stQuantity;
        this.price = price;
    }
}
