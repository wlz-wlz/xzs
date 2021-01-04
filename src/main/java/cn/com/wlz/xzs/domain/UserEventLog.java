package cn.com.wlz.xzs.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UserEventLog implements Serializable {

    private static final long serialVersionUID = -3951198127152024633L;


    public UserEventLog(){

    }

    public UserEventLog(Integer userId, String userName, String realName, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
        this.createTime = createTime;
    }

    private Integer id;

    private Integer userId;

    private String userName;

    private String realName;

    private String content;

    private Date createTime;

}
