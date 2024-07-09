package com.lyx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/6/22
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bid;
    private String bname;
    private float price;
    private String press; //出版社
    private String author; //作者
    private int number; //可借阅数量

    public Book(String bname, float price, String press, String author, int number) {
        this.bname = bname;
        this.price = price;
        this.press = press;
        this.author = author;
        this.number = number;
    }

}
