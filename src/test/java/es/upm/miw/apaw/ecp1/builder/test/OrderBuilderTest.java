package es.upm.miw.apaw.ecp1.builder.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

import es.upm.miw.apaw.ecp1.builder.OrderBuilder;
import es.upm.miw.apaw.ecp1.entities.Order;

public class OrderBuilderTest {

    @Test
    public void testNewOrder() {
        Order order = new OrderBuilder(1,new BigDecimal("5")).build();
        assertNotNull(order.getDate());
        assertEquals(new BigDecimal("5"), order.getAmount());
        assertEquals(1, order.getId());        
    }
    
    @Test
    public void testOrder() {
        Order order = new OrderBuilder(1).amount(new BigDecimal("7")).build();
        assertEquals(new BigDecimal("7"), order.getAmount());
        assertNotNull(order.getDate());
    }
    
    @Test
    public void testOrderUpdateDate() {
        Calendar now = Calendar.getInstance();
        Order order = new OrderBuilder(1).date(now).amount(new BigDecimal("5")).build();
        assertEquals(now, order.getDate());
        assertEquals(new BigDecimal("5"), order.getAmount());
        assertEquals(1, order.getId());
    }

}
