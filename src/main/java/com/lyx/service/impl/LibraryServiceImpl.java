package com.lyx.service.impl;


import com.lyx.dao.LibraryDao;
import com.lyx.dao.impl.LibraryDaoImpl;
import com.lyx.model.BookOv;
import com.lyx.model.Borrow;
import com.lyx.service.LibraryService;
import com.lyx.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    @Autowired
    private LibraryDaoImpl libraryDaoImpl;


    @Override
    public int addBook(Book book) {
        return libraryDao.addBook(book);
    }

    @Override
    public int delBook(String bname) {
        return libraryDao.delBook(bname);
    }

    @Override
    public List<Book> getBookByText(String bname) {
        //加个通配符
        return libraryDao.getBookByText("%"+bname+"%");
    }


    @Override
    public int borrowBook(String bname,int uid,int bid) {
        return libraryDao.borrowBook(bname,uid,bid);
    }

    @Override
    public int returnBook( int bid) {
        return libraryDao.returnBook(bid);
    }

    @Override
    public List<BookOv> getBorrwInfosByUid(int uid) {
        return libraryDao.getBorrwInfosByUid(uid);
    }
}
