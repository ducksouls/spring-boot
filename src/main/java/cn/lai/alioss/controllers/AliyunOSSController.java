package cn.lai.alioss.controllers;

import cn.lai.alioss.common.util.AliyunOSSUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/alioss")
public class AliyunOSSController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;

    @RequestMapping("/testUpload")
    @ResponseBody
    public String testUpload() {
        File file = new File("D:/image/ink.bmp");
        String url = aliyunOSSUtil.upLoad(file);
        System.out.println(url);
        return url + "---------" +"success";
    }

    @RequestMapping("/testDownload")
    @ResponseBody
    public String testDownload() {
        aliyunOSSUtil.downLoad(
                "test/2018-12-04/e3f892c27f07462a864a43b8187d4562-rawpixel-600782-unsplash.jpg",
                "E:/Picture/e3f892c27f07462a864a43b8187d4562-rawpixel-600782-unsplash.jpg");
        return "success";
    }

}
