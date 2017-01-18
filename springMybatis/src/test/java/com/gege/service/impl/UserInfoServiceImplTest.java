package com.gege.service.impl;

import com.gege.service.IUserInfoService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by huaaijia on 2017/1/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserInfoServiceImplTest {

    private static Logger logger = Logger.getLogger(UserInfoServiceImplTest.class);

    @Resource
    private IUserInfoService userService;

    @Test
    public void getUserById() throws Exception {
        logger.info(userService.getUserById(1).getUserName());
    }

}