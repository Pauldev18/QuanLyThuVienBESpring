package com.example.QuanLyThuVien.Controller;

import com.example.QuanLyThuVien.Entity.LibraryStaff;
import com.example.QuanLyThuVien.Service.LibraryStaffService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class LibraryStaffController {
    @Autowired
    private LibraryStaffService staffService;
    @GetMapping("/getAlllStaff")
    public List<LibraryStaff> getAllStaff(){
        return staffService.getAllStaff();
    }
    @PostMapping("/insertStaff")
    public String insertStaff(@RequestBody LibraryStaff staff){
        return staffService.insertStaff(staff);
    }
    @PutMapping("/updateStaff")
    public String updateStaff(@RequestBody LibraryStaff staff){
        return staffService.updateStaff(staff);
    }
    @DeleteMapping("/deleteStaff/{IDStaff}")
    public String deleteStaff(@PathVariable int IDStaff){
        return staffService.deleteStaff(IDStaff);
    }
}
