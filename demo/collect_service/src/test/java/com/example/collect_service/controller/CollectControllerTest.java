package com.example.collect_service.controller;

import com.example.collect_service.dao.CollectionInfo;
import com.example.collect_service.service.CollectService;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CollectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    CollectService collectService;

    @Test
    void getCollectionByUsername() throws Exception {
        List<CollectionInfo> collectionInfoList = new ArrayList<>();
        CollectionInfo book = new CollectionInfo();
        collectionInfoList.add(book);

        Mockito.when(collectService.getCollectionByUsername("test1")).thenReturn(collectionInfoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/collect/test1/collections").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.msg", is("")))
                .andExpect(jsonPath("$.data", hasSize(1)));
    }

    @Test
    void getCollection() throws Exception {
        Mockito.when(collectService.isCollect("test1", "算法导论")).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.get("/collect/test1/collections/算法导论").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.msg", is("")))
                .andExpect(jsonPath("$.data", is(true)));
    }

    @Test
    void addCollection() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/collect/test1/collections/算法导论").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.msg", is("")));
    }

    @Test
    void deleteCollection() throws Exception {
        Mockito.when(collectService.isCollect("test1", "算法导论")).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/collect/test1/collections/算法导论").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.msg", is("")));
    }
}