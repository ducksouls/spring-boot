package cn.lai.springannotation.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 11:22
 */

/**
 * xxxAware 可以
 * 实际的开发中，我们却经常要用到Spring容器本身的功能资源，
 * 所以Spring容器中的Bean此时就要意识到Spring容器的存在才能调用Spring所提供的资源。
 * 我们通过Spring提供的一系列接口
 * Spring Aware来实现具体的功能。
 *
 * 主要原理还是利用了 后置处理器 BeanPostProcessor来做处理的
 */
@Component
public class Red  implements ApplicationContextAware , BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ioc " + applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("当前名字"+s);

    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String s = stringValueResolver.resolveStringValue("你好${os.name},#{100 + 260}");
        System.out.println("-----String Value Resolver " + s);
    }
}
