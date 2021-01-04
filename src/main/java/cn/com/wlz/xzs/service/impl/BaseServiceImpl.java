package cn.com.wlz.xzs.service.impl;

import cn.com.wlz.xzs.mapper.EasyMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ program: xzs
 * @ description:
 * @ author: wanglianzeng
 * @ create: 2021-01-04 10:43
 **/
@Service
public abstract class BaseServiceImpl <M extends  EasyMapper<T>,T> extends ServiceImpl<M,T> {
}
