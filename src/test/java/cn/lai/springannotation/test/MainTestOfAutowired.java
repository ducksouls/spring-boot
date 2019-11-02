package cn.lai.springannotation.test;

import cn.lai.springannotation.config.MainConfigOfAutowired;
import cn.lai.springannotation.entity.Boss;
import cn.lai.springannotation.entity.Color;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 10:34
 */

public class MainTestOfAutowired {

    @Test
    public void  testAutoWired() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        Boss bos = annotationConfigApplicationContext.getBean(Boss.class);
        Color col = annotationConfigApplicationContext.getBean(Color.class);
        System.out.println(bos);
        System.out.println(col);


    }
}
