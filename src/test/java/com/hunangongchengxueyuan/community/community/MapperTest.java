package com.hunangongchengxueyuan.community.community;

import com.hunangongchengxueyuan.community.community.dao.DiscussPostMapper;
import com.hunangongchengxueyuan.community.community.dao.UserMapper;
import com.hunangongchengxueyuan.community.community.entity.DiscussPost;
import com.hunangongchengxueyuan.community.community.entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import com.hunangongchengxueyuan.community.community.CommunityApplication;
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectUser(){
        int id = 101;
        String name = "liubei";

        User user = (User) userMapper.selectById(id);
        System.out.println(user);

        user = (User) userMapper.selectByName(name);
        System.out.println(user);

        user = (User) userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);

        // int index  = userMapper.updateHeader(id,"url");
        // int index2 = userMapper.updatePassword(id,"0000000");



    }

    @Test
    public  void testSelectPost() {

        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
        for(DiscussPost post : list)
            System.out.println(list);

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);

    }

}
