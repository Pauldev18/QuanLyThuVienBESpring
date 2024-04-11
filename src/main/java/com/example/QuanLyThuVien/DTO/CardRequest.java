package com.example.QuanLyThuVien.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {
    private int idUser;
    private LocalDate issue;
    private LocalDate expiry;
}
