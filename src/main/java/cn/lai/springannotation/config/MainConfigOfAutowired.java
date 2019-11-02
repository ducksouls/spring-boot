package cn.lai.springannotation.config;

import cn.lai.springannotation.entity.Car;
import cn.lai.springannotation.entity.Color;
import com.sun.deploy.panel.ExceptionListDialog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 10:35
 */

/***
 * 1. 默认是选择空参构造来实例化对象(如果没有有参)
 *      当然只有一个有参,@Autowired可以省略
 * 2. 如果使用了AutoWired->在构造上--->则会调用自动注入
 *                      ->在方法上
 *                      ->参数
 * 3. AutoWired会在容器中寻找...如果不加指定,所有依赖于自动注入的bean都是同一个
 *
 *
 */
@Configuration
@ComponentScan("cn.lai.springannotation.*")
public class MainConfigOfAutowired {

    @Bean("car2")
    public Car getCar2() {
        return new Car();
    }

    @Bean
    public Car getCar() {
        return new Car();
    }

    /*@Bean
    public Color getColor(Car car){
        Color col = new Color();
        col.setCar(car);
        return col;
    }*/
}
