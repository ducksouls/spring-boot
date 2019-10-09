package cn.lai.alioss.common.util;

import cn.lai.alioss.common.constants.AliyunOSSConfigConstant;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AliyunOSSUtil {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);

    private static String FILE_URL;
    private static String bucketName = AliyunOSSConfigConstant.BUCKET_NAME;
    private static String endpoint = AliyunOSSConfigConstant.END_POINT;
    private static String accessKeyId = AliyunOSSConfigConstant.ACCESS_KEY_ID;
    private static String accessKeySecret = AliyunOSSConfigConstant.ACCESS_KEY_SECRET;
    private static String fileHost = AliyunOSSConfigConstant.FILE_HOST;

}
