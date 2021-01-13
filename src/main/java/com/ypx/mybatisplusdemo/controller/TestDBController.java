package com.ypx.mybatisplusdemo.controller;

import com.google.common.collect.ImmutableMap;
import com.ypx.mybatisplusdemo.constant.MongoConstant;
import com.ypx.mybatisplusdemo.entity.BaseInfo;
import com.ypx.mybatisplusdemo.entity.mongo.Testdb;
import com.ypx.mybatisplusdemo.service.SimpleMongoService;
import com.ypx.mybatisplusdemo.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestDBController {
    @Autowired
    private SimpleMongoService mongoService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("query")
    public ApiResult query(@RequestBody BaseInfo p){

        List<Testdb> testdb = mongoService.selectList(MongoConstant.Testdb, Testdb.class);

        //根据条件查询集合
        List<Testdb> testdbList = mongoService.selectByCondition(MongoConstant.Testdb, ImmutableMap.of("age", 23), Testdb.class, p.getPage(), p.getPageSize(), Sort.by(Sort.Order.asc("age")));

        //查询大于等于22岁数据，gte: 大于等于,lte：小于等于
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte(22));
//        Pageable pageable = PageRequest.of(p.getPage(), p.getPageSize());
//        query.with(pageable);
        List<Testdb> testdbs = mongoTemplate.find(query, Testdb.class, MongoConstant.Testdb);

        //查询数量
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("age", 23);
        Long count = mongoService.count(MongoConstant.Testdb, Testdb.class, conditions);

        return ApiResult.success(testdbs);
    }
}
