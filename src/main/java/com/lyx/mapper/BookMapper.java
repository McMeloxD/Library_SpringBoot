package com.lyx.mapper;

import com.lyx.model.Book;
import com.lyx.model.BookOv;
import com.lyx.model.Borrow;

import java.util.Date;
import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author Liyuexian
 * @date 2024/7/2
 * @desc 有待更新新的注解方式和分页功能,尽情期待
 */
public interface BookMapper {
    //添加图书
    int addBook(Book book);

    //删除图书--待更新为直接展示所有图书，右边删除按钮
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

    //查询用户是否借过这本书且还未归还
    Borrow isBorrow(String bname, int uid);

    //查询借阅未还记录
    List<BookOv> findBookWithBorrowByUid(int uid);


    //归还图书更新时间
    int updateInfo(Date rtime,int bid);

    //归还图书后更新数量
    int returnBook(int bid);

    //查询当前用户所有借阅记录
    List<Borrow> getBorrwInfosByUid(int uid);
}
