package cn.com.wlz.xzs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ program: xzs
 * @ description: 启动类
 * @ author: wanglianzeng
 * @ create: 2021-01-04 10:33
 **/
@SpringBootApplication
@MapperScan("cn.com.wlz.xzs.mapper")
public class LearnANDWantApplication {

  public static void main(String[] args) {
    //
      SpringApplication.run(LearnANDWantApplication.class,args);
  }
}
