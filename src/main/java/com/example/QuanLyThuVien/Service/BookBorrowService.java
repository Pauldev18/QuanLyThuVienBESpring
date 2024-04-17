package com.example.QuanLyThuVien.Service;

import com.example.QuanLyThuVien.DTO.MuonSach;
import com.example.QuanLyThuVien.Entity.BookBorrow;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookBorrowService {
    String muonSach(MuonSach muonSach);
    ResponseEntity<?> traSach(int bookID, String code);
    List<BookBorrow> getAllMuonTra();
}
