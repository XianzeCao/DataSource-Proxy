package com.zaccao.datasourceproxy.service.impl;

import com.zaccao.datasourceproxy.dal.model.User;
import com.zaccao.datasourceproxy.dal.mapper.UserMapper;
import com.zaccao.datasourceproxy.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
