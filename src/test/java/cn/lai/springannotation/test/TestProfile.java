package cn.lai.springannotation.test;

import cn.lai.springannotation.config.ConfigOfAware;
import cn.lai.springannotation.config.ConfigOfProfile;
import cn.lai.springannotation.entity.Red;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 15:40
 */
public class TestProfile {
    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();
        //获取环境,默认没有环境
        //annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dev");
        //注册
        annotationConfigApplicationContext.register(ConfigOfProfile .class);
        //刷新后,容器别创建
        annotationConfigApplicationContext.refresh();

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);
        for (String name:
        beanNamesForType) {
            System.out.println(name);
        }
        System.out.println();
    }
}
