package cn.lai.springannotation.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author : ZNXM-007
 * @date 2019/11/2 10:37
 */
@Component
public class Car {

    String color;
    double price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
