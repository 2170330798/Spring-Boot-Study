package com.hunangongchengxueyuan.community.community.service;

import com.hunangongchengxueyuan.community.community.dao.AlphaDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
public class AlphaService {

    public AlphaService(){
        System.out.println("实例化AlphaService");
    }


    @PostConstruct
     public  void init(){
         System.out.println("初始化AlphaService");
     }
     @PreDestroy
     public void destory(){
        System.out.println("销毁AlphaService");
     }

}
