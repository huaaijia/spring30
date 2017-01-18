package com.gege.service.impl;

import com.gege.orm.mapper.UserInfoMapper;
import com.gege.orm.pojo.UserInfo;
import com.gege.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huaaijia on 2017/1/18.
 */
@Service("userService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserById(int userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }
}
