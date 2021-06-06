package com.example.collect_service.service;

import com.example.collect_service.dao.CollectionInfo;
import com.example.collect_service.entity.Collection;
import com.example.collect_service.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CollectService {

    @Autowired
    CollectionMapper collectionMapper;

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
        return collectionMapper.getCollectionByUsername(username);
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
        List<CollectionInfo> collections = collectionMapper.getCollectionByUsername(username);
        Iterator<CollectionInfo> collectionInfoIterator = collections.iterator();
        while (collectionInfoIterator.hasNext()) {
            CollectionInfo tmp = collectionInfoIterator.next();
            if (tmp.getTitle().equals(title)) return true;
        }
        return false;
    }
}
