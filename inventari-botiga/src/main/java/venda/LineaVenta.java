package venda;

import producte.Producte;

public class LineaVenta {
    private final Producte producto;
    private final int cantidad;

    public LineaVenta(Producte producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producte getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return String.format("%s x%d → %.2f €", producto.getNombre(), cantidad, getSubtotal());
    }
}