package cn.com.wlz.xzs.service.impl;
import cn.com.wlz.xzs.configuration.property.SystemConfig;
import cn.com.wlz.xzs.configuration.spring.cache.CacheConfig;
import cn.com.wlz.xzs.domain.UserToken;
import cn.com.wlz.xzs.mapper.UserTokenMapper;
import cn.com.wlz.xzs.model.entity.user.User;
import cn.com.wlz.xzs.service.UserService;
import cn.com.wlz.xzs.service.UserTokenService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class UserTokenServiceImpl extends BaseServiceImpl<UserTokenMapper, UserToken> implements UserTokenService {

    private final static String CACHE_NAME = "Token";
    private final UserTokenMapper userTokenMapper;
    private final UserServiceImpl userService;
    private final SystemConfig systemConfig;
    private final CacheConfig cacheConfig;
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public UserTokenServiceImpl(UserTokenMapper userTokenMapper, UserService userService, UserServiceImpl userService1, SystemConfig systemConfig, CacheConfig cacheConfig, RedisTemplate<String, Object> redisTemplate) {
        this.userTokenMapper = userTokenMapper;
        this.userService = userService1;
        this.systemConfig = systemConfig;
        this.cacheConfig = cacheConfig;
        this.redisTemplate = redisTemplate;
    }




    @Override
    @Transactional
    public UserToken bind(User user) {
        user.setModifyTime(new Date());
        userService.updateById(user);
        return insertUserToken(user);
    }

    @Override
    public UserToken checkBind(String openId) {
        User user = selectByWxOpenId(openId);
        if (null != user) {
            return insertUserToken(user);
        }
        return null;
    }

    private User selectByWxOpenId(String openId) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda()
                .eq(User::getWxOpenId,openId);
        return userService.getOne(userQueryWrapper);
    }

    @Override
    @Cacheable(value = CACHE_NAME, key = "#token", unless = "#result == null")
    public UserToken getToken(String token) {
        QueryWrapper<UserToken> userTokenQueryWrapper = new QueryWrapper<>();
        userTokenQueryWrapper.lambda()
                .eq(UserToken::getToken,token);
        return getOne(userTokenQueryWrapper);
    }

    @Override
    public UserToken insertUserToken(User user) {
        Date startTime = new Date();
        Date endTime = DateUtil.endOfDay(startTime);
        UserToken userToken = new UserToken();
        userToken.setToken(UUID.randomUUID().toString());
        userToken.setUserId(user.getId());
        userToken.setWxOpenId(user.getWxOpenId());
        userToken.setCreateTime(startTime);
        userToken.setEndTime(endTime);
        userToken.setUserName(user.getUserName());
        userService.updateById(user);
        save(userToken);
        String key = cacheConfig.simpleKeyGenerator(CACHE_NAME, userToken.getToken());
        redisTemplate.opsForValue().set(key, userToken, systemConfig.getWx().getTokenToLive());
        return userToken;
    }

    @Override
    @Transactional
    public void unBind(UserToken userToken) {
        User user = userService.getById(userToken.getUserId());
        user.setModifyTime(new Date());
        user.setWxOpenId(null);
        userService.updateById(user);
        userTokenMapper.deleteById(userToken.getId());
        String key = cacheConfig.simpleKeyGenerator(CACHE_NAME, userToken.getToken());
        redisTemplate.delete(key);
    }

}
