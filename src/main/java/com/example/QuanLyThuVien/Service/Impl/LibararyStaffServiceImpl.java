package com.example.QuanLyThuVien.Service.Impl;

import com.example.QuanLyThuVien.Entity.LibraryStaff;
import com.example.QuanLyThuVien.Repository.LibraryStaffRepository;
import com.example.QuanLyThuVien.Service.LibraryStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibararyStaffServiceImpl implements LibraryStaffService {
    @Autowired
    private LibraryStaffRepository staffRepository;
    @Override
    public List<LibraryStaff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public String insertStaff(LibraryStaff staff) {
        try{
            LibraryStaff libraryStaff = new LibraryStaff();
            libraryStaff.setStaff_id(0);
            libraryStaff.setStaffName(staff.getStaffName());
            libraryStaff.setStaffContact(staff.getStaffContact());
            libraryStaff.setStaffPosition(staff.getStaffPosition());
            staffRepository.save(libraryStaff);
            return "Thêm thành công";
        }catch (Exception ex){
            return ex.getMessage();
        }

    }

    @Override
    public String updateStaff(LibraryStaff staff) {
        try{
            LibraryStaff libraryStaff = staffRepository.findById(staff.getStaff_id());
            if(libraryStaff == null){
                return "Không tìm thấy";
            }
            libraryStaff.setStaffName(staff.getStaffName());
            libraryStaff.setStaffContact(staff.getStaffContact());
            libraryStaff.setStaffPosition(staff.getStaffPosition());
            staffRepository.save(libraryStaff);
            return "Sửa thành công";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }

    @Override
    public String deleteStaff(int idStaff) {
        try{
            LibraryStaff libraryStaff = staffRepository.findById(idStaff);
            if(libraryStaff == null){
                return "Không tìm thấy";
            }
            staffRepository.delete(libraryStaff);
            return "Xóa thành công";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }
}
