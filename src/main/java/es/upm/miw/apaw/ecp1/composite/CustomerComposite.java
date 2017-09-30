package es.upm.miw.apaw.ecp1.composite;

import java.util.ArrayList;
import java.util.List;

public class CustomerComposite extends CustomerComponent {

    String name;

    List<CustomerComponent> customerCompositeList;

    public CustomerComposite(String name) {
        this.customerCompositeList = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void add(CustomerComponent customerComponent) {
        assert customerComponent != null;
        this.customerCompositeList.add(customerComponent);
    }

    @Override
    public void remove(CustomerComponent customerComponent) {
        assert customerComponent != null;
        this.customerCompositeList.remove(customerComponent);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public String view() {
        return this.name;
    }
}
