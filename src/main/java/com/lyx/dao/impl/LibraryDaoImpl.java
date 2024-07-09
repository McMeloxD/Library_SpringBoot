package com.lyx.dao.impl;

import com.lyx.dao.LibraryDao;
import com.lyx.mapper.BookMapper;
import com.lyx.model.Book;
import com.lyx.model.BookOv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
@Repository
public class LibraryDaoImpl implements LibraryDao {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int delBook(String bname) {
        return bookMapper.delBook(bname);
    }

    @Override
    public List<Book> getBookByText(String bname) {
        return bookMapper.getBookByText(bname);
    }

    @Override
    public int borrowBook(String bname,int uid,int bid) {
        int n1 = bookMapper.borrowBook(bname);
        //如果借阅成功则插入借阅记录
        if (n1 > 0) {
            Timestamp time = new java.sql.Timestamp(new java.util.Date().getTime());
            int n2 = bookMapper.addBrInfo(uid,bid,time);
            return n2;
        }
        return -1;
    }

    @Override
    public int returnBook(int bid) {
        int n1 = bookMapper.returnBook(bid);
        //如果还书数量更新成功则修改借阅记录
        if (n1 > 0) {
            Timestamp time = new java.sql.Timestamp(new java.util.Date().getTime());
            int n2 = bookMapper.updateInfo(time,bid);
            return n2;
        }
        return -1;
    }

    @Override
    public List<BookOv> getBorrwInfosByUid(int uid) {
        return bookMapper.getBorrwInfosByUid(uid);
    }


}
