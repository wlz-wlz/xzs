package cn.com.wlz.xzs.service;


import cn.com.wlz.xzs.model.entity.user.User;

/**
 * @author wlz
 */
public interface AuthenticationService {

    boolean authUser(User user, String username, String password);
}
