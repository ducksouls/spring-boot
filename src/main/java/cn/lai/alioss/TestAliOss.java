package cn.lai.alioss;

import cn.lai.alioss.common.util.AliyunOSSUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

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
        //彻底搞懂读取文件。。。。
        String path = this.getClass().getResource("/batman.jpg").getPath();
        File file = new File(path);
        String s = AliyunOSSUtil.upLoad(new File(path));
        System.out.println(s);
    }

    public static void main(String[] args) {
        String path = TestAliOss.class.getResource("/batman.jpg").getPath();
        File file = new File(path);
        String s = AliyunOSSUtil.upLoad(new File(path));
        System.out.println(s);
    }

    @Test
    public void testDownLoad(){
        AliyunOSSUtil.downLoad("img/6e6f64a35a814de5bf15f96e247985c6-batman.jpg",
                "6e6f64a35a814de5bf15f96e247985c6-batman.jpg");
    }
}

//http://lai-img.oss-cn-shenzhen.aliyuncs.com/7204ba390e4c4263a68587e0217b66eb-batman.jpg
//https://lai-img.oss-cn-shenzhen.aliyuncs.com/batman.jpg
//https://lai-img.oss-cn-hangzhou.aliyuncs.com/testImg