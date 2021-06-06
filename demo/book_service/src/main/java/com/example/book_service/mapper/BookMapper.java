package com.example.book_service.mapper;

import com.example.book_service.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 向数据库添加书信息
     * @param book 书
     * @return
     */
    @Insert("insert into book values(#{title},#{author},#{mAbstract},#{category},#{filePath},#{phases},#{imagePath});")
    int insertBook(Book book);

    /**
     * 通过title寻找书的信息
     * @param title
     * @return
     */
    @Select("select * from book where title = #{title};")
    Book getBookByTitle(@Param("title")String title);


    /**
     * 返回所有的书
     * @return
     */
    @Select("select * from book")
    List<Book> findAllBooks();

}
