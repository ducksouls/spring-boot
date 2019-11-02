package cn.lai.springannotation.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 10:37
 */


@Component
public class Boss {

    Car car;

   /* public Boss() {
    }*/

//@Autowired
    public Boss(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    /**
     *
     *自动注入可以在方法中
     */
    //@Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
