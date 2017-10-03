package es.upm.miw.apaw.ecp1.singletonfactory;

import java.util.HashMap;
import java.util.Map;

import es.upm.miw.apaw.ecp1.entities.Customer;

public class CustomerFactory {

    private static final CustomerFactory customerFactory = new CustomerFactory();

    private Map<Integer, Customer> customers;

    private CustomerFactory() {
        this.customers = new HashMap<>();
    }

    public static CustomerFactory getCustomerFactory() {
        return customerFactory;
    }

    public Customer getCustomer(int id) {
        return this.customers.get(id);
    }

    public void addCustomer(Customer customer) {
        this.customers.put(customer.getId(), customer);
    }

    public void removeCustomer(int id) {
        this.customers.remove(id);
    }

}
