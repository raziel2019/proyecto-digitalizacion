package botiga;


import org.junit.jupiter.api.Test;

import producte.Producte;

import static org.junit.jupiter.api.Assertions.*;

public class ProducteTest {

    @Test
    public void testCrearProducte() {
        System.out.println("=== testCrearProducte ===");
        Producte p = new Producte("Taza", 5.5, 10);
        System.out.println("Producto creado: " + p);

        assertEquals("Taza", p.getNombre());
        assertEquals(5.5, p.getPrecio());
        assertEquals(10, p.getStock());
    }

    @Test
    public void testDescontarStockExitoso() {
        System.out.println("=== testDescontarStockExitoso ===");
        Producte p = new Producte("Lapiz", 1.0, 5);
        System.out.println("Antes de descontar: " + p);

        boolean resultado = p.descontarStock(3);
        System.out.println("¿Descuento exitoso? " + resultado);
        System.out.println("Después de descontar: " + p);

        assertTrue(resultado);
        assertEquals(2, p.getStock());
    }

    @Test
    public void testDescontarStockFallido() {
        System.out.println("=== testDescontarStockFallido ===");
        Producte p = new Producte("Cuaderno", 3.0, 2);
        System.out.println("Antes de intentar descuento: " + p);

        boolean resultado = p.descontarStock(5);
        System.out.println("¿Descuento exitoso? " + resultado);
        System.out.println("Después de intentar descontar: " + p);

        assertFalse(resultado);
        assertEquals(2, p.getStock());
    }

    @Test
    public void testSetPrecioYStock() {
        System.out.println("=== testSetPrecioYStock ===");
        Producte p = new Producte("Botella", 2.0, 10);
        System.out.println("Estado inicial: " + p);

        p.setPrecio(3.0);
        p.setStock(20);
        System.out.println("Estado actualizado: " + p);

        assertEquals(3.0, p.getPrecio());
        assertEquals(20, p.getStock());
    }
}
