DROP DATABASE IF EXISTS Library;
CREATE DATABASE Library;
USE Library;


--Table articles
CREATE TABLE T_Articles (
    IdArticle int(4) PRIMARY KEY AUTO_INCREMENT,
    Title varchar(30) NOT NULL,
    Conditions varchar(30),
    Editor varchar(30),
    UnitaryPrice float(8)  DEFAULT 0,
    Quantity INT(4) DEFAULT 1
   -- Category int(4)
);

--Table catégories
CREATE TABLE T_Categories (
    IdCategory int(4) PRIMARY KEY AUTO_INCREMENT,
    Name varchar(30),
    Description varchar (50)
);

--Table Utilisateurs
CREATE TABLE T_Users (
	IdUser int(4) PRIMARY KEY AUTO_INCREMENT,
	NameUser varchar(30),
	Email varchar(30) NOT NULL UNIQUE,
	Phone varchar (30),
	Address varchar (30),
	Login varchar(30) NOT NULL,
	Password varchar(30) NOT NULL
);


--Table Admin
CREATE TABLE T_Admins (
	IdAdmin int (4) PRIMARY KEY AUTO_INCREMENT,
	Login varchar(30) NOT NULL,
	Password varchar(30) NOT NULL
);
--Table Orders
CREATE TABLE T_Orders (
	IdOrder int(4) PRIMARY KEY AUTO_INCREMENT,
	Amount FLOAT(8),
	Date DATE
	
);
--Table Order_Items
CREATE TABLE T_Order_Items (
	IdOrderItem int(4) PRIMARY KEY AUTO_INCREMENT,
	Quantity FLOAT(8),
	UnitaryPrice int(4)

	
);
--ALTER TABLE T_Orders ADD COLUMN IdUser int(4);
--ALTER TABLE T_Orders ADD FOREIGN KEY(IdUser) REFERENCES T_Users(IdUser);

ALTER TABLE T_Order_Items ADD COLUMN IdArticle int (4);
ALTER TABLE T_Order_Items ADD FOREIGN KEY(IdArticle) REFERENCES T_Articles(IdArticle);

ALTER TABLE T_Order_Items ADD COLUMN IdOrder int (4);
ALTER TABLE T_Order_Items ADD FOREIGN KEY(IdOrder) REFERENCES T_Orders(IdOrder);

ALTER TABLE T_Orders ADD COLUMN IdUser int (4);
ALTER TABLE T_Orders ADD FOREIGN KEY(IdUser) REFERENCES T_Users(IdUser);

ALTER TABLE T_Articles ADD COLUMN IdCategory int (4);
ALTER TABLE T_Articles ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);

INSERT INTO T_Users (Login, Password) VALUES ('Luke','force');
INSERT INTO T_Admins (Login, Password) VALUES ('mat','123');

INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('StarWars Ep1','NEW','France Loisir',65);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('StarWars Ep2','NEW','France Loisir',65);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('StarWars Ep3','NEW','France Loisir',65);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('StarWars Ep4','USED','France Loisir',45);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('StarWars Ep5','USED','France Loisir',55);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('StarWars Ep6','USED','France Loisir',85);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('StarWars Ep7','NEW','France Loisir',95);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('StarWars Ep8','NEW','France Loisir',95);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('StarWars Ep9','NEW','France Loisir',95);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('La réunion','NEW','Guide du routard',35);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('Pokémon','NEW','Chine',35);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('La cuisine créole','NEW','Marmiton',25);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('Le poëte','NEW','Livre de poche',15);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('Les rivières pourpres','NEW','Livre en or',55);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('Poldarc','NEW','Livre en or',40);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('Boule et Bill','NEW','livre de poche',5);
INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice) VALUES ('Harry potter','NEW','Bloomsbury',95);

INSERT INTO T_Categories (Name,Description) VALUES ('Science Fiction','Univers fantastique et fciton');
INSERT INTO T_Categories (Name,Description) VALUES ('Voyage','découverte');
INSERT INTO T_Categories (Name,Description) VALUES ('Jeunesse','tout age');
INSERT INTO T_Categories (Name,Description) VALUES ('Cuisine','découvrir et apprendre');
INSERT INTO T_Categories (Name,Description) VALUES ('Poésie','tout auteur');
INSERT INTO T_Categories (Name,Description) VALUES ('Polar','histoire vrai et fciton');
INSERT INTO T_Categories (Name,Description) VALUES ('Roman','Tous genres');
INSERT INTO T_Categories (Name,Description) VALUES ('petit prix','pour le plaisir de tous');
INSERT INTO T_Categories (Name,Description) VALUES ('Meilleurs ventes','Du moment');
INSERT INTO T_Categories (Name,Description) VALUES ('Langues étrangères','Bienôt disponible');
INSERT INTO T_Categories (Name,Description) VALUES ('Livres Numérique','Bienôt disponible');

UPDATE T_Articles set IdCategory=1 WHERE IdArticle=1;
UPDATE T_Articles set IdCategory=1 WHERE IdArticle=2;
UPDATE T_Articles set IdCategory=1 WHERE IdArticle=3;
UPDATE T_Articles set IdCategory=1 WHERE IdArticle=4;
UPDATE T_Articles set IdCategory=1 WHERE IdArticle=5;
UPDATE T_Articles set IdCategory=1 WHERE IdArticle=6;
UPDATE T_Articles set IdCategory=1 WHERE IdArticle=7;
UPDATE T_Articles set IdCategory=1 WHERE IdArticle=8;
UPDATE T_Articles set IdCategory=1 WHERE IdArticle=9;
UPDATE T_Articles set IdCategory=2 WHERE IdArticle=10;
UPDATE T_Articles set IdCategory=3 WHERE IdArticle=11;
UPDATE T_Articles set IdCategory=4 WHERE IdArticle=12;
UPDATE T_Articles set IdCategory=5 WHERE IdArticle=13;
UPDATE T_Articles set IdCategory=6 WHERE IdArticle=14;
UPDATE T_Articles set IdCategory=7 WHERE IdArticle=15;
UPDATE T_Articles set IdCategory=8 WHERE IdArticle=16;
UPDATE T_Articles set IdCategory=9 WHERE IdArticle=17;

--CREATE USER 'mat'@'localhost' IDENTIFIED BY '123';
--GRANT ALL PRIVILEGES ON  Library.* TO 'mat'@'localhost';
--FLUSH PRIVILEGES;