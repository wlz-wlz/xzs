package cn.com.wlz.xzs.base;


import cn.com.wlz.xzs.context.WebContext;
import cn.com.wlz.xzs.model.entity.user.User;
import cn.com.wlz.xzs.util.ModelMapperSingle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author alvis
 */
public class BaseApiController {
    protected final static String DEFAULT_PAGE_SIZE = "10";
    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();
    @Autowired
    protected WebContext webContext;

    protected User getCurrentUser() {
        return webContext.getCurrentUser();
    }
}
