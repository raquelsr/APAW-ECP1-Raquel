package es.upm.miw.apaw.ecp1.singletonfactory.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp1.builder.CustomerBuilder;
import es.upm.miw.apaw.ecp1.entities.Customer;
import es.upm.miw.apaw.ecp1.singletonfactory.CustomerFactory;

public class CustomerFactoryTest {

    Customer customer1;

    Customer customer2;

    Customer customer3;

    @Before
    public void before() {
        customer1 = new CustomerBuilder(1, "Paco").build();
        customer2 = new CustomerBuilder(2, "Pepe").build();
        customer3 = new CustomerBuilder(3, "Juan").build();
    }

    @Test
    public void testCustomerFactoryNotNull() {
        assertNotNull(CustomerFactory.getCustomerFactory());
    }

    @Test
    public void testIsSingleton() {
        assertSame(CustomerFactory.getCustomerFactory(), CustomerFactory.getCustomerFactory());
    }

    @Test
    public void testAddCustomerFactory() {
        CustomerFactory.getCustomerFactory().addCustomer(customer1);
        assertEquals(customer1, CustomerFactory.getCustomerFactory().getCustomer(customer1.getId()));
        assertNull(CustomerFactory.getCustomerFactory().getCustomer(customer2.getId()));

        CustomerFactory.getCustomerFactory().addCustomer(customer2);
        assertEquals(customer2, CustomerFactory.getCustomerFactory().getCustomer(customer2.getId()));
    }

    @Test
    public void testGetCustomerFactory() {
        CustomerFactory.getCustomerFactory().addCustomer(customer3);
        assertEquals(customer3, CustomerFactory.getCustomerFactory().getCustomer(customer3.getId()));
    }

    @Test
    public void testRemoveCustomerFactory() {
        assertNotNull(CustomerFactory.getCustomerFactory().getCustomer(customer3.getId()));
        CustomerFactory.getCustomerFactory().removeCustomer(customer3.getId());
        assertNull(CustomerFactory.getCustomerFactory().getCustomer(customer3.getId()));
    }

}
