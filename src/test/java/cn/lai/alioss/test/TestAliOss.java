package cn.lai.alioss.test;

import cn.lai.alioss.common.util.AliyunOSSUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.Test;

import java.io.File;

public class TestAliOss {
    @Test
    public void testCreateBucket() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "<yourAccessKeyId>";
        String accessKeySecret = "<yourAccessKeySecret>";
        String bucketName = "<yourBucketName>";

        // 创建OSSClient实例。

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        ossClient.createBucket(bucketName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    public void testUpload(){
        /**
         * 1. ClassLoader.getSystemResource("")
         * 2. this.getClass() .getClassLoader().getResource("")
         * 3. this.getClass().getResource("/batman.jpg")
         * 4. file:/F:/IDEA_program/spring-boot/target/test-classes/
         * file:/F:/IDEA_program/spring-boot/target/test-classes/
         * 以上都是根据classpath查找文件，但下面这个只会根据.class文件存放的位置
         * 去查找
         * this.getClass().getResource("batman.jpg")
         * file:/F:/IDEA_program/spring-boot/target/test-classes/cn/lai/alioss/test/
         */
        String path = Thread.currentThread().getContextClassLoader().getResource("batman.jpg").getPath();
        File file = new File("batman.jpg");
        AliyunOSSUtil.upLoad(new File("batman.jpg"));
    }
}
