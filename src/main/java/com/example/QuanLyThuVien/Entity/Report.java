package com.example.QuanLyThuVien.Entity;

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
@Table(name = "Reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long report_id;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "report_content", columnDefinition = "TEXT")
    private String reportContent;
}