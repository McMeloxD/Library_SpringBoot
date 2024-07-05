package com.lyx.model;

import lombok.Data;

import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/5
 * @desc
 */
@Data
public class UserVO extends User{
    private List<Borrow> borrowList;
    private String isReturn; //是否归还

    public List<Borrow> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<Borrow> borrowList) {
        this.borrowList = borrowList;
    }

    public String getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(String isReturn) {
        this.isReturn = isReturn;
    }
}
