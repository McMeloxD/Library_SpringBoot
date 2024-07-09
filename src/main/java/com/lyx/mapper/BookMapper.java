package com.lyx.mapper;

import com.lyx.model.Book;
import com.lyx.model.BookOv;
import com.lyx.model.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * --- Be Humble and Hungry ---
 *
 * @author Liyuexian
 * @date 2024/7/2
 * @desc 有待更新新的注解方式和分页功能,尽情期待
 */
@Mapper
public interface BookMapper {
    //添加图书
    @Insert("insert into book(bname,price,press,author,number) values(#{bname},#{price},#{press},#{author},#{number})")
    int addBook(Book book);

    //删除图书--待更新为直接展示所有图书，右边删除按钮
    @Delete("delete from book where bname = #{bname}")
    int delBook(String bname);

    //根据图书名查询单个图书
    @Select("select * from book where bname = #{bname}")
    Book getBookByName(String bname);

    //根据文字模糊查询图书
    @Select("select * from book where bname like #{bname}")
    List<Book> getBookByText(String bname);

    //查询一本书是否有人正在借阅
    @Select("select br.* from book b,borrow br where b.bid = br.bid and b.bname = #{bname} and rtime is null")
    Borrow getBorrowInfo(String bname);

    //查询全部图书
    @Select("select * from book")
    List<Book> getAllBook();

    //借阅图书后更新数量
    @Update("update book set number = number -1 where bname = #{bname}")
    int borrowBook(String bname);

    //借阅成功增加记录
    @Insert("insert into borrow(uid,bid,btime) values(#{param1},#{param2},#{param3})")
    int addBrInfo(int uid, int bid, Date btime);

    //查询用户是否借过这本书且还未归还
    @Select("select w.brid from borrow w,book k\n" +
            "        where w.bid = k.bid and k.bname = #{param1} and w.rtime is null and w.uid = #{param2}")
    Borrow isBorrow(String bname, int uid);

    //查询借阅未还记录
    List<BookOv> findBookWithBorrowByUid(int uid);


    //归还图书更新时间
    @Update("update borrow set rtime = #{param1} where bid = #{param2}")
    int updateInfo(Date rtime,int bid);

    //归还图书后更新数量
    @Update("update book set number = number + 1 where bid = #{bid}")
    int returnBook(int bid);

    //查询当前用户所有借阅记录
    List<BookOv> getBorrwInfosByUid(int uid);

}
