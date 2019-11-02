package cn.lai.springannotation.test;

import cn.lai.springannotation.config.ConfigOfAOP;
import cn.lai.springannotation.service.DivideZero;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 17:22
 */
public class TestAop {

    @Test
    public void testAop() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(ConfigOfAOP.class);

        DivideZero bean = annotationConfigApplicationContext.getBean(DivideZero.class);
        bean.divide(10,2);
        annotationConfigApplicationContext.close();
    }
}
