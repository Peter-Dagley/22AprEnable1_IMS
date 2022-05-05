package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long item_id = resultSet.getLong("item_id");
		String item_name = resultSet.getString("item_name");
		double price = resultSet.getDouble("price");
		Long id = resultSet.getLong("id");
		String surname = resultSet.getString("surname");
		return new Order(order_id, item_id, item_name, price, id, surname);
	}

	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"SELECT customer_orders.*, items.item_name, items.price, customers.id, customers.surname FROM customer_orders\r\n"
								+ "JOIN orders ON customer_orders.order_id=orders.order_id\r\n"
								+ "JOIN items ON customer_orders.item_id=items.id\r\n"
								+ "JOIN customers ON orders.customer_id=customers.id\r\n"
								+ "ORDER BY customer_orders.order_id ASC;");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"SELECT customer_orders.*, items.item_name, items.price, customers.id, customers.surname FROM customer_orders\r\n"
								+ "JOIN orders ON customer_orders.order_id=orders.order_id\r\n"
								+ "JOIN items ON customer_orders.item_id=items.id\r\n"
								+ "JOIN customers ON orders.customer_id=customers.id\r\n"
								+ "ORDER BY customer_orders.order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order in the database
	 * 
	 * @param order - takes in an order object. id will be ignored
	 */
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(customer_id, order_id) VALUES (?, ?)");) {
			statement.setLong(1, order.getId());
			statement.setLong(2, order.getOrder_id());
			// changed getCustomer_id to getId to accout for changes (care if reverting)
			statement.executeUpdate();
			PreparedStatement statement2 = connection
					.prepareStatement("INSERT INTO customer_orders(item_id) VALUES (?) WHERE order_id = ?, id = ?");
			{
				statement2.setLong(1, order.getItem_id());
				statement2.setLong(2, order.getOrder_id());
				statement.setLong(3, order.getId());
				statement2.executeUpdate();
				return readLatest();
			}

		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order read(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"SELECT customer_orders.*, items.item_name, items.price, customers.id, customers.surname FROM customer_orders \r\n"
								+ "JOIN orders ON customer_orders.order_id=orders.order_id\r\n"
								+ "JOIN items ON customer_orders.order_id=items.id\r\n"
								+ "JOIN customers ON orders.customer_id=customers.id\r\n"
								+ "WHERE orders.order_id = ?\r\n" + "ORDER BY customer_orders.order_id ASC");) {
			statement.setLong(1, order_id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an order in the database
	 * 
	 * @param order - takes in an order object, the id field will be used to update
	 *              that item in the database
	 * @return
	 */
	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET customer_id = ? WHERE id = ?");) {
			statement.setLong(1, order.getId());
			// changed getCustomer_id to getId to accout for changes (care if reverting)
			statement.setLong(2, order.getOrder_id());
			statement.executeUpdate();
			return read(order.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an order in the database
	 * 
	 * @param id - id of the order
	 */
	@Override
	public int delete(long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, order_id);
			PreparedStatement statement2 = connection
					.prepareStatement("DELETE FROM customer_orders WHERE order_id = ?");
			{
				statement.setLong(1, order_id);
				statement.executeUpdate();
				return statement2.executeUpdate();
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
