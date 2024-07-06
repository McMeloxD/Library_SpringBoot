package com.lyx.mapper;

import com.lyx.model.Book;
import com.lyx.model.Borrow;

import java.util.Date;
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

    //查询图书id
    Book findBookId(Book book);

    //删除图书
    int delBook(String bname);

    //根据图书名查询单个图书
    Book getBookByName(String bname);

    //根据文字模糊查询图书
    List<Book> getBookByText(String bname);

    //查询一本书是否有人正在借阅
    Borrow getBorrowInfo(String bname);

    //查询全部图书
    List<Book> getAllBook();

    //借阅图书后更新数量
    int borrowBook(String bname);

    //借阅成功增加记录
    int addBrInfo(int uid, int bid, Date btime);
}
