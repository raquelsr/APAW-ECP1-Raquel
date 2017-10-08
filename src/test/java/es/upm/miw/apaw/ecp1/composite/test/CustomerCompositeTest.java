package es.upm.miw.apaw.ecp1.composite.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.apaw.ecp1.builder.CustomerBuilder;
import es.upm.miw.apaw.ecp1.composite.CustomerComponent;
import es.upm.miw.apaw.ecp1.composite.CustomerComposite;
import es.upm.miw.apaw.ecp1.composite.CustomerLeaf;
import es.upm.miw.apaw.ecp1.entities.Customer;

public class CustomerCompositeTest {

    Customer customer;

    Customer customer2;

    Customer customer3;

    Customer customer4;

    Customer customer5;

    private CustomerComponent root;

    private CustomerComponent c1;

    private CustomerComponent c11;

    private CustomerComponent c12;

    private CustomerComponent leaf;

    private CustomerComponent leaf2;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        customer = new CustomerBuilder(1, "Paco").build();
        customer2 = new CustomerBuilder(2, "Juan").build();
        customer3 = new CustomerBuilder(3, "Pepe").build();
        customer4 = new CustomerBuilder(4, "María").build();
        customer5 = new CustomerBuilder(5, "Ana").build();

        this.root = new CustomerComposite("root");
        this.leaf = new CustomerLeaf(customer);
        this.root.add(leaf);
        this.root.add(new CustomerLeaf(customer2));

        this.c1 = new CustomerComposite("c1");
        this.root.add(c1);
        this.c11 = new CustomerComposite("c11");
        this.c12 = new CustomerComposite("c12");
        this.c1.add(c11);
        this.c1.add(new CustomerLeaf(customer3));

        this.leaf2 = new CustomerLeaf(customer4);
        this.c11.add(leaf2);
        this.c12.add(new CustomerLeaf(customer5));
    }

    @Test
    public void testIsComposite() {
        assertFalse(this.leaf.isComposite());
        assertTrue(this.c1.isComposite());
        assertTrue(this.c12.isComposite());
    }

    @Test
    public void testView() {
        assertEquals("1", this.leaf.view());
        assertEquals("4", this.leaf2.view());
        assertEquals("c1", this.c1.view());
        assertEquals("c12", this.c12.view());
    }
    
    @Test
    public void testAddLeaf() {
        exception.expect(UnsupportedOperationException.class);
        this.leaf.add(new CustomerLeaf(customer2));
    }
    
    @Test
    public void testRemove() {
        this.leaf.remove(this.leaf);
        this.c1.remove(c11);
    }
}
