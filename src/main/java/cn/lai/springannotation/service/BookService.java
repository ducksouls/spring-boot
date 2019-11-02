package cn.lai.springannotation.service;

import cn.lai.springannotation.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author  ZNXM-007
 * @date 2019/11/2 10:28
 */

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;
}
