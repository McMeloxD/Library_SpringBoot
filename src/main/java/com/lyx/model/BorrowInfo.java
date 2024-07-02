package com.lyx.model;


import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/6/22
 * @desc
 */
@Component
public class BorrowInfo {
    private int bid;
    private String bname;
    private String author;
    private float price;
    private Date ptime; //借阅时间
    private String isReturn; //是否归还

    public BorrowInfo() {
    }

    public BorrowInfo(int bid, String bname, String author,float price,Date ptime,String isReturn) {
        this.author = author;
        this.bid = bid;
        this.bname = bname;
        this.isReturn = isReturn;
        this.price = price;
        this.ptime = ptime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String isReturn() {
        return isReturn;
    }

    public void setReturn(String aReturn) {
        isReturn = aReturn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(String isReturn) {
        this.isReturn = isReturn;
    }

    @Override
    public String toString() {
        return "{" +
                "bid:" + '"'+bid +'"'+
                ", bname:" + '"'+bname +'"'+
                ", author:" + '"'+author +'"'+
                ", price:" + '"'+price +'"'+
                ", ptime:" + '"'+ptime +'"'+
                ", isReturn:" + '"'+isReturn +'"'+
                "}";
    }
}
