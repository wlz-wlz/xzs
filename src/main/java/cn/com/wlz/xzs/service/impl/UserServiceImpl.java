package cn.com.wlz.xzs.service.impl;

import cn.com.wlz.xzs.mapper.UserMapper;
import cn.com.wlz.xzs.model.entity.user.User;
import cn.com.wlz.xzs.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

/**
 * @ program: xzs
 * @ description: 用户实现
 * @ author: wanglianzeng
 * @ create: 2021-01-04 10:52
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getUserByUserName(String username) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda()
                .eq(User::getUserName,username);
        return getOne(userQueryWrapper);
    }
}
