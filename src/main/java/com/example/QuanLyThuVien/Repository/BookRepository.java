package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}