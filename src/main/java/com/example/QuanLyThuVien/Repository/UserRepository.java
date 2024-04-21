package com.example.QuanLyThuVien.Repository;

import com.example.QuanLyThuVien.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from users where user_name = ?1 and pass_word = ?2", nativeQuery = true)
    User login(String userName, String passWord);
}
