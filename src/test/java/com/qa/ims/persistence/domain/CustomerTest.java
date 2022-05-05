package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void testCustomerEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	
//	@Test
//	public void testItemEquals() {
//		EqualsVerifier.simple().forClass(Item.class).verify();
//	}
//	
//	@Test
//	public void testOrderEquals() {
//		EqualsVerifier.simple().forClass(Order.class).verify();
//	}

}
