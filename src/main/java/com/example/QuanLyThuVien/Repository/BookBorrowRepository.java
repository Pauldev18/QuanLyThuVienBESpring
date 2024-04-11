package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowRepository extends JpaRepository<BookBorrow, Integer> {
}