package com.ypx.mybatisplusdemo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypx.mybatisplusdemo.Utils.PageUtils;
import com.ypx.mybatisplusdemo.entity.User;
import com.ypx.mybatisplusdemo.service.UserService;
import com.ypx.mybatisplusdemo.vo.ApiCode;
import com.ypx.mybatisplusdemo.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author system
 * @since 2020-11-11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/userList")
    public ApiResult list(){
//        查询第一页，每页返回五条
//        Page<User> page = new Page<>(1,5);
//        QueryWrapper构造器
        IPage iPage = userService.page(new Page<>(), new QueryWrapper());

        return ApiResult.success(new PageUtils(iPage));
    }

    /**
     * lambda修改
     */


}
