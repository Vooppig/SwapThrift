CREATE TABLE TS_PRODUCT(
    PROD_ID SERIAL,
    PROD_NAME VARCHAR(200) NOT NULL,
    PROD_PRICE NUMERIC(20, 2) NOT NULL,
    PROD_DATE DATE NOT NULL,
    PROD_DATETIME TIMESTAMP NOT NULL,
    IS_AVAILABLE BOOLEAN NOT NULL,
    USER_ID INT NOT NULL,
    CAT_ID INT NOT NULL,
    SUB_CAT_ID INT
);
CREATE UNIQUE INDEX PK_TS_PRODUCT ON TS_PRODUCT(PROD_ID);
ALTER TABLE TS_PRODUCT
ADD CONSTRAINT PK_TS_PRODUCT PRIMARY KEY USING INDEX PK_TS_PRODUCT;
CREATE INDEX FK_TS_PRODUCT ON TS_PRODUCT(USER_ID, CAT_ID, SUB_CAT_ID);
ALTER TABLE TS_PRODUCT
ADD CONSTRAINT FK_TS_PRODUCT FOREIGN KEY (USER_ID) REFERENCES TS_USER_TABLE (ID);
ALTER TABLE TS_PRODUCT
ADD CONSTRAINT FK_TS_PRODUCT_CAT_ID FOREIGN KEY (CAT_ID) REFERENCES TS_PROD_CAT(ID);
ALTER TABLE TS_PRODUCT
ADD CONSTRAINT FK_TS_PRODUCT_SUB_CAT_ID FOREIGN KEY (SUB_CAT_ID) REFERENCES TS_PROD_CAT(ID);