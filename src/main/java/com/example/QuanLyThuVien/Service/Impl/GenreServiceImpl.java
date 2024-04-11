package com.example.QuanLyThuVien.Service.Impl;

import com.example.QuanLyThuVien.Entity.Genre;
import com.example.QuanLyThuVien.Repository.GenreRepository;
import com.example.QuanLyThuVien.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;
    @Override
    public List<Genre> getALlGenre() {
        return genreRepository.findAll();
    }

    @Override
    public String insertGenre(Genre genre) {
        try{
            Genre newObj = new Genre();
            newObj.setGenreName(genre.getGenreName());
            genreRepository.save(newObj);
            return "Thêm thành công";
        }catch(Exception ex){
                return ex.getMessage();
        }

    }

    @Override
    public String editGenre(Genre genre) {
        try{
            Optional<Genre> edit = genreRepository.findById(genre.getGenre_id());
            if(edit.isPresent()){
                Genre genre1 = edit.get();
                genre1.setGenreName(genre.getGenreName());
                genreRepository.save(genre1);
                return "Sửa thành công";
            }else{
                return "Lỗi";
            }
        }catch(Exception ex){
            return ex.getMessage();
        }
    }

    @Override
    public String deleteGenre(int idGenre) {
        try{
            Optional<Genre> edit = genreRepository.findById(idGenre);
            if(edit.isPresent()){
                Genre genre1 = edit.get();
                genreRepository.delete(genre1);
                return "Xóa thành công";
            }else{
                return "Lỗi";
            }
        }catch(Exception ex){
            return ex.getMessage();
        }
    }
}
