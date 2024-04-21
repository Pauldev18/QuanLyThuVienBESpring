package com.example.QuanLyThuVien.Service;

import com.example.QuanLyThuVien.Entity.LibraryStaff;

import java.util.List;

public interface LibraryStaffService {
    List<LibraryStaff> getAllStaff();
    String insertStaff(LibraryStaff staff);
    String updateStaff(LibraryStaff staff);
    String deleteStaff(int idStaff);
}
