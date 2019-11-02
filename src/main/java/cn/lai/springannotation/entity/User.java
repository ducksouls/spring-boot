package cn.lai.springannotation.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 10:24
 */

@Data
@Repository
public class User {
    private String name;
    private int age;
}
