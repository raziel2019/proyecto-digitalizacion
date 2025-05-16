package botiga;


import org.junit.jupiter.api.Test;
import producte.Producte;
import usuari.Usuari;
import venda.Venda;

import static org.junit.jupiter.api.Assertions.*;

public class VendaTest {

    @Test
    public void testAgregarLineaYTotal() {
        System.out.println("=== testAgregarLineaYTotal ===");

        Usuari u = new Usuari("Cliente", "cli@test.com", "123", Usuari.Rol.CLIENTE);
        Producte p = new Producte("Botella", 2.5, 10);

        System.out.println("Usuario comprador: " + u);
        System.out.println("Producto disponible: " + p);

        Venda venta = new Venda(u);

        boolean descontado = p.descontarStock(2);
        if (descontado) {
            venta.agregarLineaDesdeInput(p);
        }

        System.out.println("Total de la venta: " + venta.getTotal());
        assertTrue(venta.getTotal() > 0);
    }
}
