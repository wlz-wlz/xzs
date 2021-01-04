package cn.com.wlz.xzs.mapper;
import cn.com.wlz.xzs.model.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author alvis
 */

@Mapper
public interface UserMapper extends EasyMapper<User> {


}
