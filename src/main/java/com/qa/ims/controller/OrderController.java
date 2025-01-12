package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	// Reads a single thing
	public Order read() {
		LOGGER.info("Please enter the id of the order");
		Long order_id = utils.getLong();
		Order order = orderDAO.read(order_id);
		LOGGER.info(order);
		return order;	
	}
	
	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID");
		Long id = utils.getLong();	
		Order order = orderDAO.create(new Order(id));
		LOGGER.info("Order created");
		return order;
	}

	//can we add an item please :)
	public Order addItem() {
		LOGGER.info("Please enter the ID of the order you would like to add to");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter the ID of the item you would like to add");
		Long item_id = utils.getLong();
		Order order = orderDAO.addItem(new Order(order_id, item_id));
		return order;
	}
	
	
	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter a customer ID");
		Long customer_id = utils.getLong();
		Order order = orderDAO.update(new Order(order_id, customer_id));
		LOGGER.info("Order Updated");
		return order;
	}

	/**
	 * Deletes an existing order by the id of the order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}

}
