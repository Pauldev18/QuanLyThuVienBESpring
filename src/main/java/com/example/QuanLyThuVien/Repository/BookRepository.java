package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from Books where book_id = ?1 and available_quantity > 0", nativeQuery = true)
    Book getBookByID(int idbook);
    @Query(value = "select * from Books where book_id = ?1", nativeQuery = true)
    Book getBook(int idbook);
}