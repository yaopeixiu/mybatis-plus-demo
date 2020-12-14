package com.ypx.mybatisplusdemo.service.impl;

import com.ypx.mybatisplusdemo.entity.User;
import com.ypx.mybatisplusdemo.dao.UserMapper;
import com.ypx.mybatisplusdemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author system
 * @since 2020-11-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
