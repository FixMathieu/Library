DROP DATABASE IF EXISTS Library;
CREATE DATABASE Library;
USE Library;

CREATE TABLE T_OrderItems (
	IdOrderItem int(4) PRIMARY KEY AUTO_INCREMENT,
	Quantity FLOAT(8),
	UnitaryPrice int(4)
);

ALTER TABLE T_OrderItems ADD COLUMN IdArticle int (4);
ALTER TABLE T_OrderItems ADD FOREIGN KEY(IdArticle) REFERENCES T_Articles(IdArticle);

ALTER TABLE T_OrderItems ADD COLUMN IdOrder int (4);
ALTER TABLE T_OrderItems ADD FOREIGN KEY(IdOrder) REFERENCES T_Orders(IdOrder);