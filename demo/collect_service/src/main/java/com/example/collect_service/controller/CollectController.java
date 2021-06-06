package com.example.collect_service.controller;

import com.example.collect_service.dao.CollectionInfo;
import com.example.collect_service.service.CollectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "收藏模块")
public class CollectController {

    @Autowired
    CollectService collectService;

    /**
     * 获得个人收藏信息
     */
    @Operation(description = "获得个人收藏信息")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/collect/{username}/collections", method = RequestMethod.GET)
    public Map getCollectionByUsername(@PathVariable("username") String username) {
        Map<String, Object> result = new HashMap<>();
        List<CollectionInfo> collections = collectService.getCollectionByUsername(username);
        result.put("msg", "");
        result.put("code", 200);
        result.put("data", collections);

        return result;
    }

    /**
     * 查看某书是否被收藏
     */
    @Operation(description = "查看某书是否被收藏")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/collect/{username}/collections/{title}", method = RequestMethod.GET)
    public Map getCollection(@PathVariable("username") String username, @PathVariable("title") String title) {
        Map<String, Object> result = new HashMap<>();
        boolean isCollection = collectService.isCollect(username, title);
        result.put("msg", "");
        result.put("code", 200);
        result.put("data", isCollection);

        return result;
    }

    /**
     * 添加收藏
     */
    @Operation(description = "添加收藏")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/collect/{username}/collections/{title}", method = RequestMethod.POST)
    public Map addCollection(@PathVariable("username") String username, @PathVariable("title") String title) {
        collectService.setCollection(username, title);

        Map<String, Object> result = new HashMap<>();
        result.put("msg", "");
        result.put("code", 200);
        return result;
    }

    /**
     * 删除收藏
     */
    @Operation(description = "删除收藏")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/collect/{username}/collections/{title}", method = RequestMethod.DELETE)
    public Map deleteCollection(@PathVariable("username") String username, @PathVariable("title") String title) {
        collectService.deleteCollection(username, title);

        Map<String, Object> result = new HashMap<>();
        result.put("msg", "");
        result.put("code", 200);
        return result;
    }
}
