package es.upm.miw.apaw.ecp1.strategy;

public class FiguraContext {

    private FiguraGeometrica figura;

    public FiguraGeometrica getFigura() {
        return figura;
    }

    public void setFigura(FiguraGeometrica figura) {
        this.figura = figura;
    }
    
   public int numeroLados() {
        return figura.numeroLados();
    }
}
