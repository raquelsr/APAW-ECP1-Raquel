package es.upm.miw.apaw.ecp1.builder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.upm.miw.apaw.ecp1.entities.Customer;
import es.upm.miw.apaw.ecp1.entities.Order;

public class CustomerBuilder {
    
    private Customer customer;
    
    public CustomerBuilder (int id, String name) {
        this.customer = new Customer(id, name);
    }
    
    public CustomerBuilder name (String name) {
        this.customer.setName(name);
        return this;
    }
    
    public CustomerBuilder address (String address) {
        this.customer.setAddress(address);
        return this;
    }
    
    public CustomerBuilder date (Calendar date) {
        this.customer.setDate(date);
        return this;
    }
    
   /* public Order orderBuilder (int id, Calendar date, BigDecimal amount) {
        return new Order(id, date, amount);
    }*/
    
    public CustomerBuilder order (Order order) {
        assert order != null;
        List<Order> orders = this.customer.getOrders();
        if (orders == null) {
            orders = new ArrayList<Order>();
        }
        orders.add(order);
        this.customer.setOrders(orders);
        return this;   
    }
    
    public Customer build() {
        return this.customer;
    }
}
