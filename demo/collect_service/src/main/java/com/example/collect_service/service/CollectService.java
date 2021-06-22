package com.example.collect_service.service;


import com.example.collect_service.dao.CollectionInfo;
import com.example.collect_service.entity.Collection;
import com.example.collect_service.mapper.BookFeignClient;
import com.example.collect_service.mapper.CollectionMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CollectService {

    @Autowired
    CollectionMapper collectionMapper;

    @Autowired
    BookFeignClient bookFeignClient;
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
    @HystrixCommand(fallbackMethod = "collectionFallback")
    public List<CollectionInfo> getCollectionByUsername(String username) {
        List<Collection> collectionList =  collectionMapper.getCollectionByUsername(username);
        List<CollectionInfo> result = new ArrayList<>();
        collectionList.forEach(collection -> {
            CollectionInfo collectionInfo = new CollectionInfo();
            collectionInfo.setUsername(collection.getUsername());
            String title = collection.getTitle();
            collectionInfo.setTitle(title);

            Map data = (Map) bookFeignClient.findById(title).get("data");
            String imagePath = (String) data.get("imagePath");
            collectionInfo.setImagePath(imagePath);
            result.add(collectionInfo);
        });
        return result;
    }

    public List<CollectionInfo> collectionFallback(String username){
        Logger.getLogger("e-book").log(Level.WARNING, "book server connect failed");
        return null;
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
}
