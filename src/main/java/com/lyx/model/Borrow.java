package com.lyx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/5
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    private int brid; //借阅记录id
    private int uid; //用户id
    private int bid; //图书id
    private Date btime; //借阅时间
    private Date rtime; //归还时间

}
