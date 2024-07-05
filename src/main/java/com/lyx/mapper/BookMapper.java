package com.lyx.mapper;

import com.lyx.model.Book;

import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author Liyuexian
 * @date 2024/7/2
 * @desc
 */
public interface BookMapper {
    //添加图书
    int addBook(Book book);

    //查询单个图书
    Book getBookByName(String bname);

    //查询全部图书
    List<Book> getAllBook();
}
