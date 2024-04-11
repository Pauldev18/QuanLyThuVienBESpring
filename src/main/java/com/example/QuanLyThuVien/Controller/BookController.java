package com.example.QuanLyThuVien.Controller;

import com.example.QuanLyThuVien.DTO.BookRequest;
import com.example.QuanLyThuVien.Entity.Book;
import com.example.QuanLyThuVien.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/getAllBook")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }
    @PostMapping("/insertBook")
    public String insertBook(@RequestBody BookRequest bookRequest){
        return bookService.insertBook(bookRequest);
    }
    @PutMapping("/updateBook")
    public String updateBook(@RequestBody BookRequest bookRequest){
        return bookService.updateBook(bookRequest);
    }
    @DeleteMapping("/deleteBook/{IDBook}")
    public String deleteBook(@PathVariable int IDBook){
        return bookService.deleteBook(IDBook);
    }
}
