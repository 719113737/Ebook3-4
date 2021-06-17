package com.example.collect_service.service;


import com.example.collect_service.dao.CollectionInfo;
import com.example.book_service.entity.Book;
import com.example.collect_service.entity.Collection;
import com.example.collect_service.mapper.BookFeignClient;
import com.example.collect_service.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollectService {

    @Autowired
    CollectionMapper collectionMapper;

    @Autowired
    BookFeignClient bookFeignClient;

    private Map<String,String> bookImagePath = new HashMap<>();

    /**
     * 添加收藏夹信息
     *
     * @param username 用户名
     * @param title    书标题
     */
    public void setCollection(String username, String title) {
        collectionMapper.insertCollection(new Collection(username, title));
    }

    /**
     * 通过用户名查询用户收藏夹
     *
     * @param username
     * @return
     */
    public List<CollectionInfo> getCollectionByUsername(String username) {
        List<Collection> collectionList =  collectionMapper.getCollectionByUsername(username);
        List<CollectionInfo> result = new ArrayList<>();
        Map<String,String> tmp = getBooklist();
        collectionList.forEach(collection -> {
            CollectionInfo collectionInfo = new CollectionInfo();
            collectionInfo.setUsername(collection.getUsername());
            String title = collection.getTitle();
            collectionInfo.setTitle(title);

//            Map data = (Map) bookFeignClient.findById(title).get("data");
//            String imagePath = (String) data.get("imagePath");
            if(tmp.containsKey(title))collectionInfo.setImagePath(tmp.get(title));

            result.add(collectionInfo);
        });
        return result;
    }

    /**
     * 删除一条用户收藏信息
     *
     * @param username 用户名
     * @param title    书标题
     */
    public void deleteCollection(String username, String title) {
        collectionMapper.deleteCollection(new Collection(username, title));
    }

    public boolean isCollect(String username, String title) {
        List<Collection> collections = collectionMapper.getCollectionByUsername(username);
        Iterator<Collection> collectionInfoIterator = collections.iterator();
        while (collectionInfoIterator.hasNext()) {
            Collection tmp = collectionInfoIterator.next();
            if (tmp.getTitle().equals(title)) return true;
        }
        return false;
    }

    @KafkaListener(topics = "${spring.kafka.topics.collect}",groupId = "${spring.kafka.consumer.group-id}",containerFactory = "kafkaListenerContainerFactory")
    public void recieveData(Book book) {
        if (!bookImagePath.containsKey(book.getTitle())) {
            bookImagePath.put(book.getTitle(),book.getImagePath());
        }
    }

    public Map<String, String> getBooklist() {
        return this.bookImagePath;
    }
}
