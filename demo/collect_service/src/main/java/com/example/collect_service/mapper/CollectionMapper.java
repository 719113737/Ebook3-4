package com.example.collect_service.mapper;

import com.example.collect_service.dao.CollectionInfo;
import com.example.collect_service.entity.Collection;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectionMapper {

    /**
     * 添加收藏夹
     * @param collection 收藏信息
     * @return
     */
    @Insert("insert into collection values(#{username},#{title});")
    int insertCollection(Collection collection);

    /**
     * 通过用户名获取收藏信息
     * @param username 用户名
     * @return
     */
    @Select("select collection.username,collection.title,imagePath from collection " +
            "left join book on book.title = collection.title " +
            "where collection.username = #{username};")
    List<CollectionInfo> getCollectionByUsername(@Param("username")String username);


    /**
     * 删除一条收藏记录
     * @param collection 收藏记录
     * @return
     */
    @Delete("delete from collection where username = #{username} and title = #{title}")
    int deleteCollection(Collection collection);



}
