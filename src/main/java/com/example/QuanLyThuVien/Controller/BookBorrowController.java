package com.example.QuanLyThuVien.Controller;

import com.example.QuanLyThuVien.DTO.MuonSach;
import com.example.QuanLyThuVien.Entity.BookBorrow;
import com.example.QuanLyThuVien.Service.BookBorrowService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class BookBorrowController {
    @Autowired
    private BookBorrowService bookBorrowService;
    @GetMapping("/listMuonSach")
    public List<BookBorrow> getListMuonSach(){
        return bookBorrowService.getAllMuonTra();
    }
    @PostMapping("/muonsach")
    public String muonSach(@RequestBody MuonSach muonSach){
        return bookBorrowService.muonSach(muonSach);
    }
    @PostMapping("/trasach")
    public ResponseEntity<?> traSach(@RequestParam("BookID") int idBook,
                                     @RequestParam("code") String code){
        return bookBorrowService.traSach(idBook, code);
    }
}
