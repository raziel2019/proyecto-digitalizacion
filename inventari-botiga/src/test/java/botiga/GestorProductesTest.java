package botiga;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import producte.GestorProductes;
import producte.Producte;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class GestorProductesTest {

    private GestorProductes gestor;

    @BeforeEach
    public void setUp() {
        gestor = new GestorProductes();
        System.out.println("=== Nuevo GestorProductes creado ===");
    }

    @Test
    public void testCatalogoVacioAlInicio() {
        System.out.println("=== testCatalogoVacioAlInicio ===");
        boolean vacio = gestor.catalogoVacio();
        System.out.println("¿Catálogo vacío? " + vacio);
        assertTrue(vacio);
    }

    @Test
    public void testAgregarProductoYBuscarlo() {
        System.out.println("=== testAgregarProductoYBuscarlo ===");
        Producte p = new Producte("Libro", 15.0, 5);
        gestor.agregarProducto(p);
        System.out.println("Producto agregado: " + p);

        Optional<Producte> resultado = gestor.buscarPorNombre("Libro");
        System.out.println("Resultado de la búsqueda: " + (resultado.isPresent() ? resultado.get() : "No encontrado"));

        assertTrue(resultado.isPresent());
        assertEquals("Libro", resultado.get().getNombre());
    }

    @Test
    public void testEliminarProductoExistente() {
        System.out.println("=== testEliminarProductoExistente ===");
        Producte p = new Producte("Goma", 0.5, 30);
        gestor.agregarProducto(p);
        System.out.println("Producto agregado: " + p);

        boolean eliminado = gestor.eliminarProducto("Goma");
        System.out.println("¿Producto eliminado? " + eliminado);

        boolean sigueExistiendo = gestor.buscarPorNombre("Goma").isPresent();
        System.out.println("¿Sigue existiendo? " + sigueExistiendo);

        assertTrue(eliminado);
        assertFalse(sigueExistiendo);
    }

    @Test
    public void testEliminarProductoInexistente() {
        System.out.println("=== testEliminarProductoInexistente ===");
        boolean eliminado = gestor.eliminarProducto("NoExiste");
        System.out.println("¿Intento de eliminar producto inexistente? " + eliminado);
        assertFalse(eliminado);
    }
}
