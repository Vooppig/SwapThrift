CREATE TABLE PRODUCT(
    PROD_ID INT NOT NULL,
    PROD_NAME VARCHAR(200) NOT NULL,
    PROD_PRICE NUMERIC(20, 2) NOT NULL,
    PROD_DATE DATE NOT NULL,
    PROD_DATETIME TIMESTAMP NOT NULL,
    IS_AVAILABLE BOOLEAN NOT NULL,
    USER_ID INT NOT NULL,
    CAT_ID INT NOT NULL,
    SUB_CAT_ID INT
);
CREATE UNIQUE INDEX PK_PRODUCT ON PRODUCT(PROD_ID);
ALTER TABLE PRODUCT
ADD CONSTRAINT PK_PRODUCT PRIMARY KEY USING INDEX PK_PRODUCT;
CREATE INDEX FK_PRODUCT ON PRODUCT(USER_ID, CAT_ID, SUB_CAT_ID);
ALTER TABLE PRODUCT
ADD CONSTRAINT FK_PRODUCT FOREIGN KEY (USER_ID) REFERENCES USER_TABLE (ID);
ALTER TABLE PRODUCT
ADD CONSTRAINT FK_PRODUCT FOREIGN KEY (CAT_ID) REFERENCES PROD_CAT(ID);
ALTER TABLE PRODUCT
ADD CONSTRAINT FK_PRODUCT FOREIGN KEY (SUB_CAT_ID) REFERENCES PROD_CAT(ID);