DROP TABLE IF EXISTS `customer_orders`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `price` DOUBLE(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
    `order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) DEFAULT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`customer_id`) REFERENCES customers(`id`)
  );
  
  CREATE TABLE IF NOT EXISTS `customer_orders` (
`identifier` INT(11) NOT NULL AUTO_INCREMENT,
`order_id` INT DEFAULT NULL,
`item_id` INT DEFAULT NULL,
PRIMARY KEY (`identifier`),
FOREIGN KEY (`order_id`) REFERENCES orders(`order_id`),
FOREIGN KEY (`item_id`) REFERENCES orders(`id`),
);