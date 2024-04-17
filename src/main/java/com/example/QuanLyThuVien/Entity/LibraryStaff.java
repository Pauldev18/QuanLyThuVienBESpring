package com.example.QuanLyThuVien.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "library_staff")
public class LibraryStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_position")
    private String staffPosition;

    @Column(name = "staff_contact")
    private String staffContact;

    // Getters and setters
}
