package com.example.QuanLyThuVien.Service;

import com.example.QuanLyThuVien.DTO.BookRequest;
import com.example.QuanLyThuVien.Entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    String insertBook(BookRequest book);
    String updateBook(BookRequest book);
    String deleteBook(int idBook);
}
