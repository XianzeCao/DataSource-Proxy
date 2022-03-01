package com.zaccao.datasourceproxy.controller;


import com.zaccao.datasourceproxy.dal.model.User;
import com.zaccao.datasourceproxy.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping
    public int insert(@RequestBody User user){
      log.info("begin insert user: {}",user);
      boolean rs=userService.save(user);
      return rs?1:0;
    }
}
