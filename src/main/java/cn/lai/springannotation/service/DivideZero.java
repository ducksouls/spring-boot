package cn.lai.springannotation.service;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 17:00
 */
@Service
public class DivideZero {

    /**
     * 会报异常
     * @return
     */
     public double divide(double x,double y) {
         return x/y;
     }
}
