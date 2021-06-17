package com.example.book_service.service;

import com.example.book_service.entity.Book;
import com.example.book_service.mapper.BookMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Value("${spring.kafka.topics.collect}")
    private String topicName;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    KafkaTemplate<String, JSONObject> kafkaTemplate;

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

    /**
     * 提交所有书到kafka
     */
    public void submitBooks(Book book) {
        System.out.println(book.getTitle() + "is sent to the message queue" );
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title",book.getTitle());
        jsonObject.put("imagePath",book.getImagePath());

        kafkaTemplate.send(topicName,jsonObject);
        System.out.println("send successfully");
    }
}
