package cn.lai.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//springboot启动注解
//Configuration + EnableAutoConfiguration + ComponentScan结合起来
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MyspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }

}
