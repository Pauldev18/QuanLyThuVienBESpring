package com.example.QuanLyThuVien.Controller;

import com.example.QuanLyThuVien.Entity.LibraryCard;
import com.example.QuanLyThuVien.Service.LibararyCard;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class LibraryCardController {
    @Autowired
    private LibararyCard cardService;
    @GetMapping("/getAllCard")
    public List<LibraryCard> getAllCard(){
        return cardService.getAllCard();
    }
    @PostMapping("/addCard")
    public String addCard(@RequestBody LibraryCard card){
        return cardService.insertCard(card);
    }
    @PutMapping("/editCard")
    public String editCard(@RequestBody LibraryCard card){
        return cardService.updateCard(card);
    }
    @DeleteMapping("deleteCard/{IDCard}")
    public String deleteCard(@PathVariable int IDCard){
        return cardService.deleteCard(IDCard);
    }
}
