package com.lyx.controller;

import cn.hutool.json.JSONUtil;
import com.lyx.model.Book;
import com.lyx.model.BorrowInfo;
import com.lyx.model.User;
import com.lyx.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Action;
import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @RequestMapping("/addBook")
    public String addBook(String name,float price,String press,String author,
                          int number){
        Book book = new Book(name,price,press,author,number);
        //传业务层,返回最终的book集合结果
        List<Book> books = libraryService.addBook(book);
        //打印看下
        books.forEach(x -> System.out.println(x));
        //判断如果有数据就交给页面
        if (books.size()>0){
            return "forward:/BookList.jsp";
        }else return "login";
    }
}
