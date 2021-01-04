package cn.com.wlz.xzs.configuration.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author alvis
 */
@Configuration
@Data
public class SystemConfig {
    private PasswordKeyConfig pwdKey;
    private List<String> securityIgnoreUrls;
    private WxConfig wx;
    private QnConfig qn;
}
