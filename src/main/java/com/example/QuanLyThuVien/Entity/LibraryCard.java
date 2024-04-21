package com.example.QuanLyThuVien.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "library_cards")
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int card_id;

    @JsonProperty("code")
    @Column(name = "code")
    private String code;

    @JsonProperty("msv")
    @Column(name = "msv")
    private String msv;

    @JsonProperty("tenSinhVien")
    @Column(name = "ten_sinh_vien")
    private String tenSinhVien;

    @JsonProperty("lopQuanLy")
    @Column(name = "lop_quan_ly")
    private String lopQuanLy;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate issueDate;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate expiryDate;
}
