package com.lyx.dao;

import com.lyx.model.User;
import com.lyx.model.BorrowInfo;
import com.lyx.model.Book;

import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/6/26
 * @desc
 */
public interface LibraryDao {
    List<BorrowInfo> borrowInfo(User user);
    int addBook(Book book);
    int delBook(String bname);
}
