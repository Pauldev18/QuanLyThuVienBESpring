create database quanlythuvien;
use quanlythuvien;
-- Tạo bảng cho quản lý sách
CREATE TABLE Genres (
    genre_id INT AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(255) NOT NULL
);
CREATE TABLE Books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author nvarchar(255),
    genre_id INT,
    quantity INT,
    available_quantity INT,
    FOREIGN KEY (genre_id) REFERENCES Genres(genre_id)
);
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullname nvarchar(255) not null,
    user_role ENUM('admin', 'user') DEFAULT 'user'
);
-- Tạo bảng cho thẻ thư viện
CREATE TABLE library_cards (
    card_id INT AUTO_INCREMENT PRIMARY KEY,
	code nvarchar(255) not null unique,
    msv nvarchar(255) not null,
    ten_sinh_vien nvarchar(255) not null,
    lop_quan_ly nvarchar(255) not null,
    issue_date DATE,
    expiry_date DATE
);

-- Tạo bảng cho mượn/trả sách
CREATE TABLE book_borrows (
    borrow_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    card_id INT,
    borrow_date DATE,
    expected_date date,
    fine_amount float,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES Books(book_id),
    FOREIGN KEY (card_id) REFERENCES library_cards(card_id)
);

-- Tạo bảng cho nhân viên thư viện
CREATE TABLE library_staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    staff_name VARCHAR(255) NOT NULL,
    staff_position VARCHAR(255),
    staff_contact VARCHAR(255)
);
DELIMITER //
CREATE TRIGGER set_default_expected_date BEFORE INSERT ON book_borrows
FOR EACH ROW
BEGIN
    IF NEW.borrow_date IS NULL THEN
        SET NEW.borrow_date = CURDATE();
    END IF;
END;
//
DELIMITER ;

