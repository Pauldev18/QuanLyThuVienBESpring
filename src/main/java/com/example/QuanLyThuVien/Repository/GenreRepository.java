package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}