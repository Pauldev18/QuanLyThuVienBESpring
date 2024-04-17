package com.example.QuanLyThuVien.Service.Impl;

import com.example.QuanLyThuVien.DTO.MuonSach;
import com.example.QuanLyThuVien.Entity.Book;
import com.example.QuanLyThuVien.Entity.BookBorrow;
import com.example.QuanLyThuVien.Entity.LibraryCard;
import com.example.QuanLyThuVien.Repository.BookBorrowRepository;
import com.example.QuanLyThuVien.Repository.BookRepository;
import com.example.QuanLyThuVien.Repository.LibraryCardRepository;
import com.example.QuanLyThuVien.Service.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookBorrowServiceImpl implements BookBorrowService {
    @Autowired
    private BookBorrowRepository repository;
    @Autowired
    private LibraryCardRepository cardRepository;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public String muonSach(MuonSach muonSach) {
        LibraryCard card = cardRepository.getByCode(muonSach.getCode());
        Book book = bookRepository.getBookByID(muonSach.getBookID());
        if(book == null){
            return "Sách không hợp lệ";
        }
        else{
            if(card != null){
                BookBorrow bookBorrow = new BookBorrow();
                bookBorrow.setBook(book);
                bookBorrow.setLibraryCard(card);
                bookBorrow.setExpectedDate(muonSach.getNgayTraDuKien());
                repository.save(bookBorrow);
                book.setAvailableQuantity(book.getAvailableQuantity() - 1);
                bookRepository.save(book);
                return "Mượn thành công";
            }else{
                return "Thẻ không hợp lệ";
            }
        }
    }

    @Override
    public ResponseEntity<?> traSach(int bookID, String code) {
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        Book book = bookRepository.getBook(bookID);
        LibraryCard card = cardRepository.getCodeTraSach(code);
        if (card != null) {
            BookBorrow bookBorrow = repository.getTraSach(bookID, card.getCard_id());
            if (bookBorrow != null) {
                // Kiểm tra nếu ngày trả muộn
                LocalDate expectedDate = bookBorrow.getExpectedDate();
                if (currentDate.isAfter(expectedDate)) {

                    long lateDays = expectedDate.until(currentDate).getDays();
                    // Tính phạt
                    float fine = lateDays * 5000;
                    if(fine < 0.0){
                        bookBorrow.setFineAmount(0);
                    }else{
                        bookBorrow.setFineAmount(fine);
                    }
                } else {
                    bookBorrow.setFineAmount(0);
                }
                bookBorrow.setReturnDate(currentDate);
                repository.save(bookBorrow);
                book.setAvailableQuantity(book.getAvailableQuantity() + 1);
                return new ResponseEntity<>(bookBorrow, HttpStatus.OK) ;
            } else {
                return new ResponseEntity<>("Lỗi", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Thẻ không hợp lệ", HttpStatus.OK);
        }
    }

    @Override
    public List<BookBorrow> getAllMuonTra() {
        return repository.findAll();
    }
}
