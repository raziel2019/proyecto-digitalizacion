package venda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import producte.Producte;
import usuari.Usuari;
import utilitats.InputHelper;

public class Venda {
    private LocalDateTime fecha;
    private Usuari usuario;
    private List<LineaVenta> lineas;

    public Venda(Usuari usuario) {
        this.fecha = LocalDateTime.now();
        this.usuario = usuario;
        this.lineas = new ArrayList<>();
    }

    public void agregarLineaDesdeInput(Producte producto) {
        System.out.print("Cantidad para " + producto.getNombre() + ": ");
        int cantidad = InputHelper.readPositiveInteger();
        if (producto.descontarStock(cantidad)) {
            lineas.add(new LineaVenta(producto, cantidad));
            System.out.println("Producto añadido a la venta.");
        } else {
            System.out.println("No hay suficiente stock.");
        }
    }

    public double getTotal() {
        return lineas.stream().mapToDouble(LineaVenta::getSubtotal).sum();
    }

    public List<LineaVenta> getLineas() {
        return lineas;
    }

    public Usuari getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Usuario: ").append(usuario != null ? usuario.getNombre() : "Anónimo").append("\n");
        for (LineaVenta linea : lineas) {
            sb.append(linea).append("\n");
        }
        sb.append("Total: ").append(getTotal());
        return sb.toString();
    }
}
