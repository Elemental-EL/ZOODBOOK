package org.example.zoodbook;

import javafx.scene.chart.LineChart;

public class Books {
    Long bookId;
    String bookName;
    int stQuantity;
    String price;

    public Books(Long bookId, String bookName, int stQuantity, String price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.stQuantity = stQuantity;
        this.price = price;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getStQuantity() {
        return stQuantity;
    }

    public void setStQuantity(int stQuantity) {
        this.stQuantity = stQuantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    //    Books(Long bookId , String bookName, int stQuantity , String price){
//        this.bookId = bookId;
//        this.bookName = bookName;
//        this.stQuantity = stQuantity;
//        this.price = price;
//    }

}
