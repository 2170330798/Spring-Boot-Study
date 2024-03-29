package com.hunangongchengxueyuan.community.community;


import com.hunangongchengxueyuan.community.community.dao.AlphaDao;
import com.hunangongchengxueyuan.community.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public  class CommunityApplicationTests implements ApplicationContextAware {

	private  ApplicationContext applicationContext;
	@Override
	public  void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
	}
    @Test
	public  void testApplicationContext(){
		System.out.println(applicationContext);

		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		alphaDao = applicationContext.getBean("alphaHibernate",AlphaDao.class);
		System.out.println(alphaDao.select());

	}
    @Test
	public  void  testBeanManage(){

		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
	   System.out.println(alphaService);
	}

	@Test
	public  void testBeanConfig(){
		SimpleDateFormat simpleDateFormat =
				applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));

	}


}
