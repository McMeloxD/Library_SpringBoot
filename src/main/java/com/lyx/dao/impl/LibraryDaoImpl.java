package com.lyx.dao.impl;

import com.lyx.dao.LibraryDao;
import com.lyx.model.Book;
import com.lyx.model.BorrowInfo;
import com.lyx.model.User;
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


    @Override
    public List<BorrowInfo> borrowInfo(User user) {
        System.out.println("持久层执行");
        return Collections.emptyList();
    }

    @Override
    public List<Book> addBook(Book book) {
        return Collections.emptyList();
    }
}
