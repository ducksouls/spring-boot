package cn.lai.alioss.test;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;


public class TestOssAPI {
    String objName;
    String endpoint;
    String accessKeyId;
    String accessKeySecret;
    String bucketName;
    OSS ossClient;
    @Before
    public void BeforeTets(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        accessKeyId = "LTAI4FfTPTbFqt5sfxiG9SZa";
        accessKeySecret = "L4fRnTdFpgyFeujUL6vKwJZedrfw2z";
        bucketName = "lai-img";
        objName = "testStr";
        // 创建OSSClient实例。
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    @Test
    public void testCreateBucket() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        String accessKeyId = "LTAI4FfTPTbFqt5sfxiG9SZa";
        String accessKeySecret = "L4fRnTdFpgyFeujUL6vKwJZedrfw2z";
        String bucketName = "lai-img";

        // 创建OSSClient实例。

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        ossClient.createBucket(bucketName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    public void testUpload(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        String accessKeyId = "LTAI4FfTPTbFqt5sfxiG9SZa";
        String accessKeySecret = "L4fRnTdFpgyFeujUL6vKwJZedrfw2z";
        String bucketName = "lai-img";
        String objName = "testStr1";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        String content = "Hello";
        ossClient.putObject(bucketName, objName, new ByteArrayInputStream(content.getBytes()));
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    public void testDownLoad() throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        String accessKeyId = "LTAI4FfTPTbFqt5sfxiG9SZa";
        String accessKeySecret = "L4fRnTdFpgyFeujUL6vKwJZedrfw2z";
        String bucketName = "lai-img";
        String objName = "testStr";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
        OSSObject ossObject = ossClient.getObject(bucketName, objName);
        // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
        InputStream content = ossObject.getObjectContent();
        if (content != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println("\n" + line);
            }
            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
            content.close();
        }

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    public void testEmuration() {
        ObjectListing objectListing = ossClient.listObjects(bucketName);
        for (OSSObjectSummary obj: objectListing.getObjectSummaries()) {
            System.out.println(" - " + obj.getKey() + "  " +
                    "(size = " + obj.getSize() + ")");
        }

    }

    @Test
    public void testDelete() {
        ossClient.deleteObject(bucketName, "testStr1");

    }

    @After
    public void afterTest(){
        ossClient.shutdown();
    }
}
