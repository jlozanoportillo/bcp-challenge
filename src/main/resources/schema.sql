DROP TABLE IF EXISTS currency;

CREATE TABLE currency (
  id   INT AUTO_INCREMENT  PRIMARY KEY,
  label  VARCHAR(5),
  changeamount DECIMAL(5,3)
);
INSERT INTO CURRENCY(LABEL, CHANGEAMOUNT) VALUES('PEN',0.277);
INSERT INTO CURRENCY(LABEL, CHANGEAMOUNT) VALUES('EUR',1.21);



