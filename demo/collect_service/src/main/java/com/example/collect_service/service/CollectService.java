package com.example.collect_service.service;


import com.example.collect_service.dao.CollectionInfo;
import com.example.collect_service.entity.Collection;
import com.example.collect_service.mapper.BookFeignClient;
import com.example.collect_service.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
