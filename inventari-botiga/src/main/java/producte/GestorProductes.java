package producte;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import utilitats.InputHelper;

public class GestorProductes {
    private final List<Producte> catalogo;

    public GestorProductes() {
        this.catalogo = new ArrayList<>();
    }

    public void agregarProducto(Producte p) {
        catalogo.add(p);
    }

    public boolean catalogoVacio() {
        return catalogo.isEmpty();
    }
    
    public void agregarProductoDesdeInput() {
        System.out.println("\n=== Agregar nuevo producto ===");
        String nombre = InputHelper.readString();
        double precio = InputHelper.readDecimal();
        int stock = InputHelper.readPositiveInteger();
        Producte producto = new Producte(nombre, precio, stock);
        agregarProducto(producto);
        System.out.println("Producto agregado.");
    }

    public boolean eliminarProducto(String nombre) {
        return catalogo.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public Optional<Producte> buscarPorNombre(String nombre) {
        return catalogo.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    public void listarProductos() {
        System.out.println("=== Catálogo de Productos ===");
        for (Producte p : catalogo) {
            System.out.println(p);
        }
    }
}
