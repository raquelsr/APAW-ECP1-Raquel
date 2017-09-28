package es.upm.miw.apaw.ecp1.builder.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp1.builder.CustomerBuilder;
import es.upm.miw.apaw.ecp1.entities.Customer;
import es.upm.miw.apaw.ecp1.entities.Order;

public class CustomerBuilderTest {

    Order order1;

    Order order2;

    Order order3;

    @Before
    public void before() {
        Calendar calendar = Calendar.getInstance();
        order1 = new Order(1, calendar, new BigDecimal("2"));
        order2 = new Order(2, calendar, new BigDecimal("4"));
        order3 = new Order(3, calendar, new BigDecimal("7"));
    }

    @Test
    public void testCustomerBuilder() {
        Calendar calendar = Calendar.getInstance();
        Customer customer = new CustomerBuilder(1, "Paco").address("Calle Francia").date(calendar).build();
        assertEquals("Paco", customer.getName());
        assertEquals("Calle Francia", customer.getAddress());
        assertEquals(calendar, customer.getDate());
        assertEquals(null, customer.getOrders());
        assertEquals(1, customer.getId());
    }

    @Test
    public void testOrder() {
        Calendar calendar = Calendar.getInstance();
        Order order = new Order(1, calendar, new BigDecimal("4"));
        assertEquals(1, order.getId());
        assertEquals(new BigDecimal("4"), order.getAmount());
        assertEquals(calendar, order.getDate());
    }

    @Test
    public void testCustomerOrder() {
        Calendar calendar = Calendar.getInstance();
        Order order = new Order(1, calendar, new BigDecimal("4"));
        Order order2 = new Order(2, calendar, new BigDecimal("7"));
        Customer customer = new CustomerBuilder(1, "Paco").address("Calle Francia").order(order).build();
        assertTrue(customer.orderContain(order));
        assertFalse(customer.orderContain(order2));

        customer = new CustomerBuilder(1, "Paco").address("Calle Francia").date(calendar).order(order).order(order2).build();
        assertTrue(customer.orderContain(order2));
        assertTrue(customer.orderContain(order));
        assertEquals(calendar, customer.getDate());
    }

    @Test 
    public void testNewOrder() {
        Customer customer = new CustomerBuilder(3, "Alvaro").order(order2).order(order3).build();
        assertTrue(customer.orderContain(order2));
        assertTrue(customer.orderContain(order3));
        assertFalse(customer.orderContain(order1));
    }
}
