package com.example.QuanLyThuVien.Service.Impl;

import com.example.QuanLyThuVien.Entity.User;
import com.example.QuanLyThuVien.Repository.UserRepository;
import com.example.QuanLyThuVien.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String insertUser(User user) {
        try{
            User newObj = new User();
            user.setFullname(user.getFullname());
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            userRepository.save(user);
            return "Thêm thaành công";
        }catch(Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    public String updateUser(User user) {
       return null;
    }

    @Override
    public String deleteUser(int idUser) {
        return null;
    }
}
