package com.example.book_service.service;

import com.example.book_service.entity.Book;
import com.example.book_service.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    /**
     * 通过title获得书信息
     *
     * @param title
     * @return
     */
    public Book getBookByTitle(String title) {
        return bookMapper.getBookByTitle(title);
    }


    /**
     * 返回文件路径
     *
     * @param title 书标题
     * @return
     */
    public String getPathByTitle(String title) {
        Book book = bookMapper.getBookByTitle(title);
        return book.getFilePath();
    }

}
