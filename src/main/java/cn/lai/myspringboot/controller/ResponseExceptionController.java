package cn.lai.myspringboot.controller;

import cn.lai.myspringboot.exception.NotFoundException;
import cn.lai.myspringboot.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * 有些奇怪，如果assignableTypes设置为全局（不设值）就会发现请求时200
 *  把这个方法放入被处理的controller中也会200
 *
 */
@RestController
@RequestMapping("/exception")
public class ResponseExceptionController {

    /**
     * 这中方式就不需要加入注解
     */
    @GetMapping("/nfe")
    public void throwException3() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "fuck me, not found!",
                new ResourceNotFoundException());
    }

    /**
     * 在要抛出的异常中加入了@ResponseStatus注解
     */
    @GetMapping("/nfe1")
    public void throwException4() {
        throw new NotFoundException("fuck me, not found!");
    }
}
