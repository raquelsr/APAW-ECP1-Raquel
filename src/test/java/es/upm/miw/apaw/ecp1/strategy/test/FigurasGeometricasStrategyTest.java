package es.upm.miw.apaw.ecp1.strategy.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp1.strategy.Cuadrado;
import es.upm.miw.apaw.ecp1.strategy.FiguraContext;
import es.upm.miw.apaw.ecp1.strategy.Pentagono;
import es.upm.miw.apaw.ecp1.strategy.Triangulo;

public class FigurasGeometricasStrategyTest {

    FiguraContext figurasGeometricasContext;
    
    @Before
    public void before() {
        figurasGeometricasContext = new FiguraContext();
    }
    
    @Test
    public void testGetFigura() {
        Triangulo triangulo = new Triangulo();
        this.figurasGeometricasContext.setFigura(triangulo);
        assertEquals(triangulo,figurasGeometricasContext.getFigura());
    }
    
    @Test
    public void testTriangulo() {
        this.figurasGeometricasContext.setFigura(new Triangulo());
        assertEquals(3, this.figurasGeometricasContext.numeroLados());
    }
    
    @Test
    public void testCuadrado() {
        this.figurasGeometricasContext.setFigura(new Cuadrado());
        assertEquals(4, this.figurasGeometricasContext.numeroLados());       
    }
    
    @Test
    public void testPentagono() {
        this.figurasGeometricasContext.setFigura(new Pentagono());
        assertEquals(5, this.figurasGeometricasContext.numeroLados());
    }
}
