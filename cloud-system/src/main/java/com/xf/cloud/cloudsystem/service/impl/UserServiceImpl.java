package com.xf.cloud.cloudsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xf.cloud.cloudsystem.entity.User;
import com.xf.cloud.cloudsystem.mapper.UserMapper;
import com.xf.cloud.cloudsystem.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  user实现类 继承ServiceImpl
 * </p>
 *
 * @author xf
 * @date 2021-04-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
