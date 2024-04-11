package com.example.QuanLyThuVien.Service;

import com.example.QuanLyThuVien.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    String insertUser(User user);
    String updateUser(User user);
    String deleteUser(int idUser);
}
