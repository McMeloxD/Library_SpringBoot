package com.lyx.service;

import com.lyx.model.Book;
import com.lyx.model.BookOv;
import com.lyx.model.Borrow;


import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
public interface LibraryService {
    int addBook(Book book);
    int delBook(String bname);
    List<Book> getBookByText(String bname);
    int borrowBook(String bname,int uid,int bid);
    int returnBook(int bid);
    List<BookOv> getBorrwInfosByUid(int uid);

}
