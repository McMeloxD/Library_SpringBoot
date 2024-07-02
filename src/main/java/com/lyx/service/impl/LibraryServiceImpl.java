package com.lyx.service.impl;


import com.lyx.dao.LibraryDao;
import com.lyx.service.LibraryService;
import com.lyx.model.Book;
import com.lyx.model.BorrowInfo;
import com.lyx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/6/26
 * @desc
 */
@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    @Override
    public List<BorrowInfo> borrowInfo(User user) {
        System.out.println("业务层执行");
        List<BorrowInfo> infos = libraryDao.borrowInfo(user);
        return infos;
    }

    @Override
    public List<Book> addBook(Book book) {
        List<Book> books = libraryDao.addBook(book);
        return books;
    }
}
