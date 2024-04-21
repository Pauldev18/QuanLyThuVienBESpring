package com.example.QuanLyThuVien.Service.Impl;

import com.example.QuanLyThuVien.Entity.User;
import com.example.QuanLyThuVien.Repository.UserRepository;
import com.example.QuanLyThuVien.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> login(String userName, String passWord) {
        User user = userRepository.login(userName, passWord);
        if(user == null){
            return  new ResponseEntity<>("Tài khoản hoặc mật khẩu không chính xác", HttpStatus.NOT_FOUND);
        }else{
            return  new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

}
