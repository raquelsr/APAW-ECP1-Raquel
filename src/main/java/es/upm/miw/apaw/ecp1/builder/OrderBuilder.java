package es.upm.miw.apaw.ecp1.builder;


import java.math.BigDecimal;
import java.util.Calendar;

import es.upm.miw.apaw.ecp1.entities.Order;

public class OrderBuilder {

    private Order order;
    
    public OrderBuilder (int id, Calendar date, BigDecimal amount) {
        this.order = new Order (id, date, amount);
    }
    
    public OrderBuilder date (Calendar date) {
        this.order.setDate(date);
        return this;
    }
    
    public OrderBuilder amount (BigDecimal amount) {
        this.order.setAmount(amount);
        return this;
    }
    
    public Order build() {
        return this.order;
    }
}
