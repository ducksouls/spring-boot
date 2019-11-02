package cn.lai.springannotation.test;

import cn.lai.springannotation.config.ConfigOfAware;
import cn.lai.springannotation.entity.Red;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 11:47
 */
public class MainTestOfAware {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigOfAware.class);
        Red red = annotationConfigApplicationContext.getBean(Red.class);
        System.out.println(red);
    }
}

