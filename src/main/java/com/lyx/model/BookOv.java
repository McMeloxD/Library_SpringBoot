package com.lyx.model;

import lombok.Data;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/6
 * @desc
 */

@Data
public class BookOv extends Book{
    private Borrow borrow;

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
}
