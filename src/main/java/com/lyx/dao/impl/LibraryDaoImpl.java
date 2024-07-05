package com.lyx.dao.impl;

import com.lyx.dao.LibraryDao;
import com.lyx.mapper.BookMapper;
import com.lyx.mapper.UserMapper;
import com.lyx.model.Book;
import com.lyx.model.BorrowInfo;
import com.lyx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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
    public List<BorrowInfo> borrowInfo(User user) {
        return null;
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }
}
