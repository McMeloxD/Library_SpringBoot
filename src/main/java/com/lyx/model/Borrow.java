package com.lyx.model;

import java.util.Date;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/5
 * @desc
 */
public class Borrow {
    private int brid; //借阅记录id
    private int uid; //用户id
    private int bid; //图书id
    private Date btime; //借阅时间
    private Date rtime; //归还时间

    public Borrow() {
    }

    public Borrow(int brid, int uid, int bid, Date btime, Date rtime) {
        this.brid = brid;
        this.uid = uid;
        this.bid = bid;
        this.btime = btime;
        this.rtime = rtime;
    }

    public int getBrid() {
        return brid;
    }

    public void setBrid(int brid) {
        this.brid = brid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "brid=" + brid +
                ", uid=" + uid +
                ", bid=" + bid +
                ", btime=" + btime +
                ", rtime=" + rtime +
                '}';
    }
}
