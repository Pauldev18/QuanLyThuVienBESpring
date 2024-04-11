create database quanlythuvien;
use quanlythuvien;
-- Tạo bảng cho quản lý sách
CREATE TABLE Genres (
    genre_id INT AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(255) NOT NULL
);

-- Tạo bảng cho tác giả
CREATE TABLE Authors (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(255) NOT NULL
);

CREATE TABLE Books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INT,
    genre_id INT,
    quantity INT,
    available_quantity INT,
    FOREIGN KEY (author_id) REFERENCES Authors(author_id),
    FOREIGN KEY (genre_id) REFERENCES Genres(genre_id)
);
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_role ENUM('admin', 'user') DEFAULT 'user'
);

-- Tạo bảng cho thẻ thư viện
CREATE TABLE LibraryCards (
    card_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    issue_date DATE,
    expiry_date DATE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Tạo bảng cho mượn/trả sách
CREATE TABLE BookBorrows (
    borrow_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    card_id INT,
    borrow_date DATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES Books(book_id),
    FOREIGN KEY (card_id) REFERENCES LibraryCards(card_id)
);

-- Tạo bảng cho nhân viên thư viện
CREATE TABLE LibraryStaff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    staff_name VARCHAR(255) NOT NULL,
    staff_position VARCHAR(255),
    staff_contact VARCHAR(255)
);

-- Tạo bảng cho báo cáo thống kê
CREATE TABLE Reports (
    report_id INT AUTO_INCREMENT PRIMARY KEY,
    report_type VARCHAR(255),
    report_date DATE,
    report_content TEXT
);