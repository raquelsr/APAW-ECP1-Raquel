package es.upm.miw.apaw.ecp1.composite;

public interface CustomerComponent {
   
    public void add (CustomerComponent customerComponent);
    public void remove (CustomerComponent customerComponent);
    public boolean isComposite ();
    public String view();
    
}
