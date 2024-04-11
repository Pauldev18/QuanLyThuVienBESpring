package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}