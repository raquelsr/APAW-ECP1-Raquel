package es.upm.miw.ecp1.composite;

public abstract class CustomerComponent {
   
    public abstract void add (CustomerComponent customerComponent);
    public abstract void remove (CustomerComponent customerComponent);
    public abstract boolean isComposite ();
    public abstract String view();
    
}
