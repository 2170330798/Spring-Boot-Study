package com.hunangongchengxueyuan.community.community.service;

import com.hunangongchengxueyuan.community.community.dao.UserMapper;
import com.hunangongchengxueyuan.community.community.entity.User;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public User findUserById(int id){
      return  (User) userMapper.selectById(id);
  }

}
