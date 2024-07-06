package com.lyx.service;

import com.lyx.model.Book;
import com.lyx.model.BorrowInfo;
import com.lyx.model.User;

import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
public interface LibraryService {
    List<BorrowInfo> borrowInfo(User user);
    int addBook(Book book);
    int delBook(String bname);
    List<Book> getBookByText(String bname);
    int borrowBook(String bname,int uid,int bid);
}
