CREATE TABLE purchase_product(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    purchase_id BIGINT NOT NULL ,
    product_id BIGINT NOT NULL ,
    quantity INT NOT NULL ,
    price DECIMAL(10,2) NOT NULL
);