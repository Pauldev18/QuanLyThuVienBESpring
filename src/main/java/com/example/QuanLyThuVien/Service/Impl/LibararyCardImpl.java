package com.example.QuanLyThuVien.Service.Impl;

import com.example.QuanLyThuVien.Entity.LibraryCard;
import com.example.QuanLyThuVien.Repository.LibraryCardRepository;
import com.example.QuanLyThuVien.Service.LibararyCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibararyCardImpl implements LibararyCard {

    @Autowired
    private LibraryCardRepository cardRepository;
    @Override
    public List<LibraryCard> getAllCard() {
        return cardRepository.findAll();
    }

    @Override
    public String insertCard(LibraryCard card) {
        try{
            LibraryCard newObj = new LibraryCard();
            newObj.setCard_id(0);
            newObj.setCode(card.getCode());
            newObj.setMsv(card.getMsv());
            newObj.setLopQuanLy(card.getLopQuanLy());
            newObj.setIssueDate(card.getIssueDate());
            newObj.setExpiryDate(card.getExpiryDate());
            cardRepository.save(newObj);
            return "Thêm thành công";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }

    @Override
    public String updateCard(LibraryCard card) {
        try{
            Optional<LibraryCard> libraryCard = cardRepository.findById(card.getCard_id());
            if(libraryCard.isPresent()){
                return "Không tìm thấy card";
            }
            LibraryCard update = libraryCard.get();
            update.setCode(card.getCode());
            update.setMsv(card.getMsv());
            update.setTenSinhVien(card.getTenSinhVien());
            update.setLopQuanLy(card.getLopQuanLy());
            update.setIssueDate(card.getIssueDate());
            update.setExpiryDate(card.getExpiryDate());
            cardRepository.save(update);
            return "Update thành công";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }

    @Override
    public String deleteCard(int idCard) {
        try{
            Optional<LibraryCard> libraryCard = cardRepository.findById(idCard);
            if(libraryCard.isPresent()){
                return "Không tìm thấy card";
            }
            LibraryCard update = libraryCard.get();
            cardRepository.delete(update);
            return "Xóa thành công";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }
}
