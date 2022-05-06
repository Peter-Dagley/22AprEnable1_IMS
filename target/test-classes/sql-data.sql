INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

INSERT INTO `items` (`item_name`, `price`) VALUES ('apple', 1.00);

INSERT INTO `orders` (`customer_id`) VALUES (1);

INSERT INTO `customer_orders` (`order_id`, `item_id`) VALUES (1, 1)