package cn.lai.springannotation.config;

import cn.lai.springannotation.aop.LogAspect;
import cn.lai.springannotation.service.DivideZero;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 17:05
 */

/**
 * 启用注解
 */
@EnableAspectJAutoProxy
@Configuration
public class ConfigOfAOP {
    @Bean
    public DivideZero divideZero() {
        return new DivideZero();
    }
    @Bean
    public LogAspect LogAspect() {
        return new  LogAspect();
    }
}
