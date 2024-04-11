package com.example.QuanLyThuVien.Service.Impl;

import com.example.QuanLyThuVien.DTO.BookRequest;
import com.example.QuanLyThuVien.Entity.Book;
import com.example.QuanLyThuVien.Entity.Genre;
import com.example.QuanLyThuVien.Repository.BookRepository;
import com.example.QuanLyThuVien.Repository.GenreRepository;
import com.example.QuanLyThuVien.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.PropertyPermission;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public String insertBook(BookRequest book) {
        try{
            Optional<Genre> genre = genreRepository.findById(book.getIdGenre());
            if(genre.isPresent()){
                Genre genre1 = genre.get();
                Book newObj = new Book();
                newObj.setAuthor(book.getAuthor());
                newObj.setTitle(book.getTitle());
                newObj.setGenre(genre1);
                newObj.setQuantity(book.getQuantity());
                newObj.setAvailableQuantity(book.getAvailableQuantity());
                bookRepository.save(newObj);
                return "Thêm thành công";
            }else{
                return "Không tìm thấy genre";
            }
        }catch (Exception ex){
            return ex.getMessage();
        }

    }

    @Override
    public String updateBook(BookRequest book) {
       try{
            Optional<Book> getBook = bookRepository.findById(book.getIdBook());
            Optional<Genre> getGenre = genreRepository.findById(book.getIdGenre());

            if(getBook.isPresent() && getGenre.isPresent()){
                Book edit = getBook.get();
                Genre genre = getGenre.get();
                edit.setAvailableQuantity(book.getAvailableQuantity());
                edit.setQuantity(book.getQuantity());
                edit.setAuthor(book.getAuthor());
                edit.setGenre(genre);
                edit.setTitle(book.getTitle());
                bookRepository.save(edit);
                return "Sửa thành công";
            }else{
                return "Lỗi";
            }
       }catch (Exception ex){
           return ex.getMessage();
       }
    }

    @Override
    public String deleteBook(int idBook) {
        try{
            Optional<Book> getBook = bookRepository.findById(idBook);
            if(getBook.isPresent()){
                Book edit = getBook.get();
                bookRepository.delete(edit);
                return "Xoas thành công";
            }else{
                return "Lỗi";
            }
        }catch (Exception ex){
            return ex.getMessage();
        }
    }
}
