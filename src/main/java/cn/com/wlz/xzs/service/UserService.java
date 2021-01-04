package cn.com.wlz.xzs.service;

import cn.com.wlz.xzs.model.entity.user.User;

public interface UserService {
    User getUserByUserName(String username);
}
