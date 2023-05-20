package com.hunangongchengxueyuan.community.community.dao;
import com.hunangongchengxueyuan.community.community.dao.AlphaDao;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository("alphaHibernate")
public class AlphaDaoHibernatelmpl implements AlphaDao {
    @Override
    public  String select(){
        return  "Hibernate";
    }
}
