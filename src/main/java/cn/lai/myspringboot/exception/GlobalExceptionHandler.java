package cn.lai.myspringboot.exception;

import cn.lai.myspringboot.controller.ExceptionController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理
 */
@ControllerAdvice(assignableTypes = ExceptionController.class)//默认为全局处理，亦可以指定处理某个controller的异常
@ResponseBody
public class GlobalExceptionHandler {
    ErrorResponse illegalArgumentResponse =
            new ErrorResponse(new IllegalArgumentException("参数错误!"));
    ErrorResponse resourseNotFoundResponse =
            new ErrorResponse(new ResourceNotFoundException("Sorry, the resourse not found!"));
//    ErrorResponse notFoundResponse =
//            new ErrorResponse(new NotFoundException("Fuck you, not found"));

    @ExceptionHandler(value = Exception.class)// 拦截所有异常, 这里只是为了演示，一般情况下一个方法特定处理一种异常
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {

        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        } else if (e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(404).body(resourseNotFoundResponse);
//        } else {
//            ResponseEntity.status(404).body(notFoundResponse);
//        }

        }
        return null;
    }


}

