package com.example.QuanLyThuVien.Service;

import com.example.QuanLyThuVien.Entity.LibraryCard;

import java.util.List;

public interface LibararyCard {
    List<LibraryCard> getAllCard();
    String insertCard(LibraryCard card);
    String updateCard(LibraryCard card);
    String deleteCard(int idCard);
}
