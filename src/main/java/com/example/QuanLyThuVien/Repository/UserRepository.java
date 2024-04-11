package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
