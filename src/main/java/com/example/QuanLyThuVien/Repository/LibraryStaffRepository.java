package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.LibraryStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryStaffRepository extends JpaRepository<LibraryStaff, Integer> {
    LibraryStaff findById(int id);
}