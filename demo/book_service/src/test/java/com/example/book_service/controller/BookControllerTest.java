package com.example.book_service.controller;

import com.example.book_service.entity.Book;
import com.example.book_service.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    BookService bookService;

    @Test
    void getBooks() throws Exception {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book("a", "a", "a", "a", "a", "a", "a");
        bookList.add(book);

        Mockito.when(bookService.findAllBooks()).thenReturn(bookList);

        mockMvc.perform(MockMvcRequestBuilders.get("/books").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.msg", is("")))
                .andExpect(jsonPath("$.data", hasSize(1)));
    }

    @Test
    void getBookByTitle() throws Exception {
        Book book = new Book("a", "a", "a", "a", "a", "a", "a");

        Mockito.when(bookService.getBookByTitle("算法导论")).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/算法导论").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.msg", is("")));
    }
}