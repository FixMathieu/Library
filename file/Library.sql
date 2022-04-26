DROP DATABASE IF EXISTS Library;
CREATE DATABASE Library;
USE Library;


--Table articles
CREATE TABLE T_Articles (
    IdArticle int(4) PRIMARY KEY AUTO_INCREMENT,
    Title varchar(30) NOT NULL,
    Conditions varchar(30),
    Editor varchar(30),
    UnitaryPrice float(8) NOT NULL DEFAULT 0,
    Quantity INT(4)DEFAULT 1,
    Category int(4)
);

--Table catégories
CREATE TABLE T_Categories (
    IdCategory int(4) PRIMARY KEY AUTO_INCREMENT,
    Name varchar(30) NOT NULL,
    Description varchar (30)
);

--Table Utilisateurs
CREATE TABLE T_Users (
	IdUser int(4) PRIMARY KEY AUTO_INCREMENT,
	NameUser varchar(30),
	Email varchar(30),
	Tel varchar (30),
	adress varchar (30),
	Login varchar(30) NOT NULL,
	Password varchar(30) NOT NULL
);


--Table Admin
CREATE TABLE T_Admins (
	IdAdmin int (4) PRIMARY KEY AUTO_INCREMENT,
	Login varchar(30) NOT NULL,
	Password varchar(30) NOT NULL
);


--ALTER TABLE T_Articles ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);

INSERT INTO T_Users (Login, Password) VALUES ('Luke','force');
INSERT INTO T_Admins (Login, Password) VALUES ('mat','123');
