package cn.lai.myspringboot.controller;

import cn.lai.myspringboot.exception.NotFoundException;
import cn.lai.myspringboot.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @GetMapping("/illegalArgumentException")
    public void throwException() {
        throw new IllegalArgumentException();
        /**
         * {
         *     "message": "参数错误!",
         *     "errorTypeName": "java.lang.IllegalArgumentException"
         * }
         */
    }

    @GetMapping("/resourceNotFoundException")
    public void throwException2() {
        throw new ResourceNotFoundException();
        /**
         * {
         *     "message": "Sorry, the resourse not found!",
         *     "errorTypeName": "cn.lai.myspringboot.exception.ResourceNotFoundException"
         * }
         */
    }


}

