package com.gege.service;

import com.gege.orm.pojo.UserInfo;

/**
 * Created by huaaijia on 2017/1/18.
 */
public interface IUserInfoService {
    UserInfo getUserById(int userId);
}
