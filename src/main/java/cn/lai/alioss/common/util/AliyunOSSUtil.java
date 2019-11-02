package cn.lai.alioss.common.util;

import cn.lai.alioss.common.constants.AliyunOSSConfigConstant;
import com.aliyun.oss.*;
import com.aliyun.oss.model.*;
import org.slf4j.LoggerFactory;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class AliyunOSSUtil {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);

    private static String FILE_URL;
    private static String bucketName = AliyunOSSConfigConstant.BUCKET_NAME;
    private static String endpoint = AliyunOSSConfigConstant.END_POINT;
    private static String accessKeyId = AliyunOSSConfigConstant.ACCESS_KEY_ID;
    private static String accessKeySecret = AliyunOSSConfigConstant.ACCESS_KEY_SECRET;
    private static String fileHost = AliyunOSSConfigConstant.FILE_HOST;

    /**
     * 上传文件。
     *
     * @param file 需要上传的文件路径
     * @return 如果上传的文件是图片的话，会返回图片的"URL"，
     * 如果非图片的话会返回"非图片，不可预览。文件路径为：+文件路径"
     */
    public static String upLoad(File file) {
        //0. 判断文件是否为null
        if (file == null) {
            return null;
        }
        //1.判断上传的是否为图片格式
        boolean isImage = true;
        try {
            Image image = ImageIO.read(file);
            isImage = image != null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("------------文件上传-----------" + file.getName());
        //2. 获取ossClient
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //3. 判断bucket是否存在，不存在则创建
        try {
            if(!ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                 // 设置存储空间的权限为公共读，默认是私有。
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                // 设置存储空间的存储类型为低频访问类型，默认是标准类型。
                createBucketRequest.setStorageClass(StorageClass.IA);
                ossClient.createBucket(createBucketRequest);
            }
            //4. 上传
            String upFileName =   UUID.randomUUID().toString().replace("-", "") + "-" + file.getName();
            PutObjectResult testImg = ossClient.putObject(bucketName, "img/"+upFileName, file);

            if (isImage) {//如果是图片，则图片的URL为：....
                FILE_URL =   fileHost + "img/" +upFileName;
            } else {
                FILE_URL = "非图片，不可预览。文件路径为：" + upFileName;
            }
            if(testImg!=null) {
                logger.info("------OSS文件上传成功------" + FILE_URL);
            }
        } catch (OSSException e) {
//            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (ClientException e) {
//            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return FILE_URL;
    }

    /**
     * 下载
     * @param objName oss服务器上的图片名字
     * @param localName 存储在本地的图片名字
     */
    public static void downLoad(String objName,String localName) {
        OSS client = null;
        try {
            client = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
            String s = objName.split("/")[1];
            File parent = new File("img/");
            File file = new File(parent,s);
            if (!parent.exists()) {
                parent.mkdirs();
            }
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectMetadata object = client.getObject(new GetObjectRequest(bucketName, objName), file);

            logger.info("---------下载成功-------"+localName);
        } catch (OSSException e) {
            logger.error(e.getMessage());
        } catch (ClientException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client !=null) {
                client.shutdown();
            }
        }
    }

}
