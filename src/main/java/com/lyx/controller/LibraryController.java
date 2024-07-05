package com.lyx.controller;

import com.lyx.mapper.BookMapper;
import com.lyx.model.Book;
import com.lyx.service.LibraryService;
import com.lyx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/5
 * @desc
 */
@RestController
public class LibraryController {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/addBook")
    public R addBook(String bname, float price, String press, String author, int number) {
        System.out.println(new Book(bname, price, press, author, number));
        // 先判断是否已经存在这本书
        Book book1 = bookMapper.getBookByName(bname);
        System.out.println(book1);
        if (book1 == null) {
            int n = libraryService.addBook(new Book(bname, price, press, author, number));
            System.out.println(n);
            // 插入成功,查询最新图书表，返回集合
            if (n > 0) {
                List<Book> books = bookMapper.getAllBook();
                books.forEach(x -> System.out.println(x));
                return new R(20000, "添加成功！", books);
            } else return new R(40000, "添加失败~", null);
        } else return new R(50000, "图书馆已经有这本书了呢~", null);
    }
}
