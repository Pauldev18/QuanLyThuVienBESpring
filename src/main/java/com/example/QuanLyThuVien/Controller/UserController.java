package com.example.QuanLyThuVien.Controller;

import com.example.QuanLyThuVien.Entity.User;
import com.example.QuanLyThuVien.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping("/insertUser")
    public String insertUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
