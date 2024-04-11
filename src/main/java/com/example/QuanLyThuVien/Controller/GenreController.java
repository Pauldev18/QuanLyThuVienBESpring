package com.example.QuanLyThuVien.Controller;

import com.example.QuanLyThuVien.Entity.Genre;
import com.example.QuanLyThuVien.Service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/getListGenre")
    public List<Genre> getListGenre(){
        return genreService.getALlGenre();
    }

    @PostMapping("/insertGenre")
    public String insertGenre(@RequestBody Genre genre){
        return genreService.insertGenre(genre);
    }
    @PutMapping("/updateGenre")
    public String updateGenre(@RequestBody Genre genre){
        return genreService.editGenre(genre);
    }
    @DeleteMapping("/deleteGenre/{IDGenre}")
    public String deleteGenre(@PathVariable int IDGenre){
        return genreService.deleteGenre(IDGenre);
    }
}
