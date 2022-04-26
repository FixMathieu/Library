DROP DATABASE IF EXISTS Library;
CREATE DATABASE Library;
USE Library;

CREATE TABLE T_Articles (
	IdArticle int(4) PRIMARY KEY AUTO_INCREMENT,
	Title varchar(30),
	Conditions varchar(30),
	Category INT(4),
	Editor varchar (30),
	UnitaryPrice FLOAT(8),
	Quantity int(4)
);