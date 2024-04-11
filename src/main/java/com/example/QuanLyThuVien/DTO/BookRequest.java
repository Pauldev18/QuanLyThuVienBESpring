package com.example.QuanLyThuVien.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private int idBook;
    private String title;
    private String author;
    private int idGenre;
    private int quantity;
    private int availableQuantity;
}
