package com.example.QuanLyThuVien.Service;

import com.example.QuanLyThuVien.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    ResponseEntity<?> login(String userName, String passWord);

}
