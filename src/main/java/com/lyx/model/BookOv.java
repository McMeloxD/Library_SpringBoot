package com.lyx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/6
 * @desc
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookOv extends Book{
    private Borrow borrow;

}
