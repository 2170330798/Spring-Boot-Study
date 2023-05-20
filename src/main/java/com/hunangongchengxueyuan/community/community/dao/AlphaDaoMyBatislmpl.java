package com.hunangongchengxueyuan.community.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.hunangongchengxueyuan.community.community.dao.AlphaDao;
@Repository
@Primary
public class AlphaDaoMyBatislmpl implements AlphaDao {
    @Override
    public String select(){
        return "MyBatis";
    }
}
