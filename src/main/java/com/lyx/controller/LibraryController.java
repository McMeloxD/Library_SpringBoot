package com.lyx.controller;

import com.lyx.mapper.BookMapper;
import com.lyx.model.Book;
import com.lyx.model.BookOv;
import com.lyx.model.Borrow;
import com.lyx.service.LibraryService;
import com.lyx.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/5
 * @desc
 */
@RestController
@RequestMapping("/api/book/")
@Api(tags = "图书接口")
public class LibraryController {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/addBook")
    @ApiOperation(value = "添加图书")
    public R addBook(String bname, float price, String press, String author, int number) {
        // 先判断是否已经存在这本书
        Book book1 = bookMapper.getBookByName(bname);
        System.out.println(bname);
        if (book1 == null) {
            int n = libraryService.addBook(new Book(bname, price, press, author, number));
            // 插入成功,查询最新图书表，返回集合
            if (n > 0) {
                List<Book> books = bookMapper.getAllBook();
                return new R(20000, "添加成功！", books);
            } else return new R(40000, "添加失败~", null);
        } else return new R(50000, "图书馆已经有这本书了呢~", null);
    }

    @GetMapping("/delBook")
    @ApiOperation(value = "删除图书")
    public R delBook(String bname) {
        System.out.println(bname);
        // 先判断是否由这本书
        // Book book = bookMapper.getBookByName(bname);
        // if (book == null) {
        //     return new R(50000, "没有这本书哦~", null);
        // }
        // 再判断这本书是否有人正在借阅
        Borrow borrow = bookMapper.getBorrowInfo(bname);
        if (borrow == null) {
            // 如果为空说明目前没人借阅这本书，可以删除
            int i = libraryService.delBook(bname);
            if (i > 0){
                //删除成功返回最新图书列表
                List<Book> books = bookMapper.getAllBook();
                return new R(20000,"删除成功！",books);
            }else return new R(30000,"删除失败~",null);
        }else return new R(40000,"删除失败！这本书有人正在借阅中哦~",null);
    }

    @GetMapping("/findBook")
    @ApiOperation(value = "模糊查找图书")
    public R findBook(String bname) {
        List<Book> books = libraryService.getBookByText(bname);
        if (!books.isEmpty()) {
            return new R(20000,"查询成功！",books);
        }else return new R(40000,"没有这本书呢~",null);
    }

    @GetMapping("/borrowBook")
    @ApiOperation(value = "借阅图书")
    public R borrowBook(String bname,int uid,int bid) {
        //查询用户是否借过这本书且未还
        Borrow borrow = bookMapper.isBorrow(bname,uid);
        if (borrow == null) {
            //如果没有就直接进行借阅功能
            int i = libraryService.borrowBook(bname,uid,bid);
            if (i > 0) {
                return new R(20000,"借阅成功，记得归还哦~",null);
            }else return new R(40000,"借阅失败，请联系管理员290945973@qq.com",null);
        }else return new R(30000,"您之前借过这本《"+ bname + "》还没归还哦~",null);
    }

    @GetMapping("/bookList")
    @ApiOperation(value = "图书列表")
    public R bookList() {
        List<Book> books = bookMapper.getAllBook();
        if (books != null) {
            return new R(20000,"获取图书成功",books);
        }else return new R(50000,"获取失败",null);
    }

    @GetMapping("/allInfo")
    @ApiOperation(value = "用户所有借阅信息")
    public R allInfo(int uid) {
        List<BookOv> borrows = libraryService.getBorrwInfosByUid(uid);
        if (borrows != null) {
            return new R(20000,"获取借阅d记录成功",borrows);
        }else return new R(50000,"获取失败",null);
    }

    @GetMapping("/bookNotReturnInfo")
    @ApiOperation(value = "用户未归还图书")
    public R bookNotReturnInfo(int uid) throws ParseException {
        List<BookOv> bookOv = bookMapper.findBookWithBorrowByUid(uid);
        if (bookOv != null) {
            return new R(20000,"查询成功", bookOv);
        }else return new R(50000,"查询失败",null);
    }

    @GetMapping("/returnBook")
    @ApiOperation(value = "归还图书")
    public R returnBook(int bid) {
        int i = libraryService.returnBook(bid);
        if (i > 0) {
            return new R(20000,"归还成功~",null);
        }else return new R(40000,"归还失败,请联系管理员~",null);
    }

    @GetMapping("/ceshi404")
    public R ceshi404() {
        int n = 5/0;
        return new R(50000,"异常",n);
    }
}
