package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
    @Query(value = "SELECT * FROM library_cards WHERE code = ?1 AND issue_date <= CURRENT_DATE() AND expiry_date >= CURRENT_DATE()", nativeQuery = true)
    LibraryCard getByCode(String code);
    @Query(value = "SELECT * FROM library_cards WHERE code = ?1", nativeQuery = true)
    LibraryCard getCodeTraSach(String code);
}
