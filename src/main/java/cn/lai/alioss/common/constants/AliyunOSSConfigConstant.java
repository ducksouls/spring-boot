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
//  主  LTAI4FeUzn5qBDe3sj9mNnaZ
//子   LTAI4FfTPTbFqt5sfxiG9SZa
    public static final String ACCESS_KEY_ID = "LTAI4FfTPTbFqt5sfxiG9SZa";
//    主 4Pji4roNfvGJaHrVxtt77gjMBYySPk
//    子 L4fRnTdFpgyFeujUL6vKwJZedrfw2z
    public static final String ACCESS_KEY_SECRET = "L4fRnTdFpgyFeujUL6vKwJZedrfw2z";
    public static final String FILE_HOST = "http://lai-img.oss-cn-shenzhen.aliyuncs.com/";

}
