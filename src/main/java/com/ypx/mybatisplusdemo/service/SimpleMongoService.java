package com.ypx.mybatisplusdemo.service;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface SimpleMongoService<T> {
    void createCollection(String name);

    String createIndex(String collectionName, String filedName);

    List<String> getAllIndexes(String collectionName);

    void insert(T info, String collectionName);

    void insertMulti(List<T> infos, String collectionName);

    void updateById(String id, String collectionName, T info);

    void deleteById(String id, Class<T> clazz, String collectionName);

    T selectById(String id, Class<T> clazz, String collectionName);

    List<T> selectList(String collectName, Class<T> clazz);

    List<T> selectList(String collectName, Class<T> clazz, Integer currentPage, Integer pageSize, Sort sort);

    List<T> selectByCondition(String collectName, Map<String, Object> conditions, Class<T> clazz, Integer currentPage, Integer pageSize, Sort sort);

    List<T> selectByCondition(String collectName, Map<String, Object> conditions, Class<T> clazz);

    T selectOneByCondition(String collectName, Map<String, Object> conditions, Class<T> clazz);

    List<T> selectLike(String collectName, Map<String, Object> conditions, Class<T> clazz);

    Long count(String collectName, Class<T> clazz, Map<String, Object> conditions);
}

