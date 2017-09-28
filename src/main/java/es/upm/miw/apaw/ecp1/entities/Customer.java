package es.upm.miw.apaw.ecp1.entities;

import java.util.Calendar;
import java.util.List;

public class Customer {

    private int id;
    
    private String name;
    
    private String address;
    
    private Calendar date;
    
    private List<Order> orders;
    
    public Customer (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", date=" + date + ", orders=" + orders + "]";
    }
    
    
    
    
}