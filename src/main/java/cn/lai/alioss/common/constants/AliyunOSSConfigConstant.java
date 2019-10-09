package cn.lai.alioss.common.constants;

/**
 * spring-boot常量配置类
 * 1.使用配置类
 * 2.使用.propertis文件，再用@ConfigurationProperties
 */
public class AliyunOSSConfigConstant {
    //私有构造方法 禁止该类初始化
    private AliyunOSSConfigConstant() {
    }

    public static final String BUCKET_NAME = "lai-img";
    public static final String END_POINT = "http://oss-cn-shenzhen.aliyuncs.com";
    public static final String ACCESS_KEY_ID = "LTAI4FeUzn5qBDe3sj9mNnaZ";
    public static final String ACCESS_KEY_SECRET = "4Pji4roNfvGJaHrVxtt77gjMBYySPk";
    public static final String FILE_HOST = "test";

}
