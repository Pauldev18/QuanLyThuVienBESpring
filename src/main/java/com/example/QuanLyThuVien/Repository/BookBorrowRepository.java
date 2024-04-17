package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowRepository extends JpaRepository<BookBorrow, Integer> {
    @Query(value = "SELECT * FROM book_borrows WHERE book_id = ?1 AND card_id = ?2 AND return_date IS NULL", nativeQuery = true)
    BookBorrow getTraSach(int idbook, int idcard);
}