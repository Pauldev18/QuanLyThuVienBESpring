package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {
}