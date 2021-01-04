package cn.com.wlz.xzs.service.impl;

import cn.com.wlz.xzs.configuration.property.SystemConfig;
import cn.com.wlz.xzs.util.RsaUtil;
import cn.com.wlz.xzs.mapper.UserMapper;
import cn.com.wlz.xzs.model.entity.user.User;
import cn.com.wlz.xzs.service.AuthenticationService;
import cn.com.wlz.xzs.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @ program: xzs
 * @ description:
 * @ author: wanglianzeng
 * @ create: 2021-01-04 11:20
 **/
@Service
public class AuthenticationServiceImpl extends BaseServiceImpl<UserMapper, User> implements AuthenticationService {

    private final UserService userService;
    private final SystemConfig systemConfig;

    public AuthenticationServiceImpl(UserService userService, SystemConfig systemConfig) {
        this.userService = userService;
        this.systemConfig = systemConfig;
    }

    @Override
    public boolean authUser(User user, String username, String password) {
        User user1 = userService.getUserByUserName(username);
        return checkAuthUser(user,username,password);
    }
    public boolean checkAuthUser(User user,String username,String password){

        if (ObjectUtils.isEmpty(user)){
            return false;
        }
        String password1 = user.getPassword();
        if (StringUtils.isEmpty(password1)){
            return false;
        }
        String s = pwdEncode(password1);
        return s.equals(password);
    }

    public String pwdEncode(String password) {
        return RsaUtil.rsaEncode(systemConfig.getPwdKey().getPublicKey(), password);
    }

    public String pwdDecode(String encodePwd) {
        return RsaUtil.rsaDecode(systemConfig.getPwdKey().getPrivateKey(), encodePwd);
    }
}
