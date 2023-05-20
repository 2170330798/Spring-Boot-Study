package com.hunangongchengxueyuan.community.community.dao;

import com.hunangongchengxueyuan.community.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param注解用于给参数取别名
    int selectDiscussPostRows(@Param("userId") int userId);


}

























