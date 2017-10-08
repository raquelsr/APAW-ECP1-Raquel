package es.upm.miw.apaw.ecp1.composite;

import es.upm.miw.apaw.ecp1.entities.Customer;

public class CustomerLeaf implements CustomerComponent {

    private Customer customer;

    public CustomerLeaf(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void add(CustomerComponent customerComponent) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    @Override
    public void remove(CustomerComponent customerComponent) {
        // Do nothing because is leaf
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public String view() {
        return String.valueOf(this.customer.getId());
    }

}
