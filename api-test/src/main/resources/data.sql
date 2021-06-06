DROP TABLE IF EXISTS Mockorder;
CREATE TABLE Mockorder(
  id VARCHAR(50) PRIMARY KEY,
  security VARCHAR(50) NOT NULL,
  status  ENUM('Pending', 'Done') NOT NULL,
  order_type ENUM('Buy','Sell') NOT NULL,
  price DECIMAL(10,2)
);

INSERT INTO Mockorder(id, security, status, order_type, price) 
VALUES
('ca1bb0d4-967b-4468-a9ad-c8f93f82fbc5','DE000BASF115','Pending','Sell',3.15),
('ca1bb0d4-967b-4468-a9ad-c8f93f82fbc6','DE000BASF116','Done','Buy',3.16),
('ca1bb0d4-967b-4468-a9ad-c8f93f82fbc7','DE000BASF117','Done','Sell',3.17),
('ca1bb0d4-967b-4468-a9ad-c8f93f82fbc8','DE000BASF118','Pending','Sell',null),
('1','DE000BASF111','Pending','Sell',3.18);