create database QLSV01
use QLSV01
CREATE TABLE students (
    id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    PRIMARY KEY (id)
)
insert into students values
(1,N'Nguyễn Anh Tú','abc@gmail.com','039788888')
select * from students