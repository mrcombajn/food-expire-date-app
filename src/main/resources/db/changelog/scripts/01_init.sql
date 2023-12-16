CREATE TABLE IF NOT EXISTS product(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        description VARCHAR(512) DEFAULT '',
                        bar_code VARCHAR(255) NOT NULL,
                        expire_date DATE NOT NULL
);
CREATE TABLE IF NOT EXISTS recipes(
                        id INT AUTO_INCREMENT PRIMARY KEY ,
                        name VARCHAR(50) NOT NULL ,
                        ingredients VARCHAR(512) NOT NULL ,
                        description VARCHAR(255) DEFAULT '',
                        steps VARCHAR(1024)
);
CREATE TABLE IF NOT EXISTS recipes_product (
                                 product_id INT,
                                 recipe_id INT,
                                 FOREIGN KEY (product_id) REFERENCES product(id),
                                 FOREIGN KEY (recipe_id) REFERENCES recipes(id)
);
INSERT INTO product(name, description, bar_code, expire_date)
VALUES('Ciecierzyca', 'Ciecierzyca w słoiku', '5601009983063', '2024-05-21');