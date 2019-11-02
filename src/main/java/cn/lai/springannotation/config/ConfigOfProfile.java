package cn.lai.springannotation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 14:26
 */

/**
 * profile:
 *  根据当前环境,动态激活和切换一些组件的功能
 *
 * 开发环境,测试,生产
 *
 * 标识了profile后,只有激活对应的环境,这个bea才会被加载,默认是default环境
 * 即,默认都不会被激活
 */
@Component
public class ConfigOfProfile implements EmbeddedValueResolverAware {

    StringValueResolver resolver;

    @Value("${spring.datasource.username}")
    private String username;
    private String url;
    @Value("${spring.datasource.password}")
    private String pwd;

    //@Profile("default")
    @Profile("test")
    @Bean("test")
    DataSource dataSourceTest() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setUrl(url+"qvdb");
        druidDataSource.setPassword(pwd);
        return druidDataSource;
    }
    @Profile("dev")
    @Bean("dev")
    DataSource dataSourceDev() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setUrl(url+"sop");
        druidDataSource.setPassword(pwd);
        return druidDataSource;
    }
    @Profile("product")
    @Bean("product")
    DataSource dataSourceProd() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setUrl(url+"sop_test");
        druidDataSource.setPassword(pwd);
        return druidDataSource;
    }


    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        this.url = this.resolver.resolveStringValue("${spring.datasource.url}");
    }
}
