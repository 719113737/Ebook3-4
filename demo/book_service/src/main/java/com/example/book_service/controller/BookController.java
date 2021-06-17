package com.example.book_service.controller;

import com.example.book_service.entity.Book;
import com.example.book_service.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Tag(name = "书本操作模块")
public class BookController {
    @Autowired
    BookService bookService;

    /**
     * 获得书列表
     */
    @Operation(description = "获得书籍列表")
    //@RequestMapping(path = "/books", method = RequestMethod.GET)
    @GetMapping("/books")
    public Map getBooks() {
        List<Book> books = bookService.findAllBooks();
        books.forEach(book -> {
            //提交所有的书到kafka
            bookService.submitBooks(book);
        });
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "");
        result.put("code", 200);
        result.put("data", books);

        return result;
    }

    /**
     * 获得特定书信息
     */
    @Operation(description = "获得特定书籍信息")
    @RequestMapping(path = "/books/{title}", method = RequestMethod.GET)
    public Map getBookByTitle(@PathVariable("title") String title) {
        Book book = bookService.getBookByTitle(title);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "");
        map.put("code", 200);
        map.put("data", book);
        return map;
    }
}
