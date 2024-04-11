package com.example.QuanLyThuVien.Service;

import com.example.QuanLyThuVien.Entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getALlGenre();
    String insertGenre(Genre genre);
    String editGenre(Genre genre);
    String deleteGenre(int idGenre);
}
