package com.lyx.model;

import org.springframework.stereotype.Component;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/6/22
 * @desc
 */
@Component
public class Book {
    private int bid;
    private String bname;
    private float price;
    private String press; //出版社
    private String author; //作者
    private int number; //可借阅数量

    public Book(){}

    public Book(int bid, String bname, float price, String press, String author, int number) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.press = press;
        this.author = author;
        this.number = number;
    }

    public Book(String bname, float price, String press, String author, int number) {
        this.bname = bname;
        this.price = price;
        this.press = press;
        this.author = author;
        this.number = number;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "{" +
                "bid:" + '"'+bid +'"'+
                ", bname:" + '"'+bname +'"'+
                ", author:" + '"'+author +'"'+
                ", price:" + '"'+price +'"'+
                ", press:" + '"'+press +'"'+
                ", number:" + '"'+number +'"'+
                "}";
    }
}
