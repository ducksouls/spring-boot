package cn.lai.myspringboot.controller;


import cn.lai.myspringboot.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 将返回的对象数据直接以 JSON 或 XML 形式写入 HTTP 响应(Response)中。
 * （@Controller +@ResponseBody= @RestController）
 */
@RestController
/**
 * 使用@RequestMapping(method=ActionType)来缩小这个映射
 */
@RequestMapping("/api")
public class BookController {
    private List<Book> books = new ArrayList<Book>();

    /**
     * ResponseEntity
     * 表示整个HTTP Response：状态码，标头和正文内容。我们可以使用它来自定义HTTP Response 的内容。
     */

    @PostMapping("/book")//相应对象
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id) {
        books.remove(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book")
    public ResponseEntity getBookByName(@RequestParam("name") String name) {
        List<Book> results = books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
}
