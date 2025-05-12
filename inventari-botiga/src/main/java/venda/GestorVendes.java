package venda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorVendes {
    private List<Venda> ventas;

    public GestorVendes() {
        this.ventas = new ArrayList<>();
    }

    public void registrarVenta(Venda venta) {
        ventas.add(venta);
    }

    public List<Venda> getVentas() {
        return ventas;
    }

    public Map<String, Integer> resumenPorProducto() {
        Map<String, Integer> resumen = new HashMap<>();
        for (Venda venta : ventas) {
            for (LineaVenta linea : venta.getLineas()) {
                String nombre = linea.getProducto().getNombre();
                resumen.put(nombre, resumen.getOrDefault(nombre, 0) + linea.getCantidad());
            }
        }
        return resumen;
    }

    public Map<String, Double> resumenPorUsuario() {
        Map<String, Double> resumen = new HashMap<>();
        for (Venda venta : ventas) {
            String nombre = venta.getUsuario() != null ? venta.getUsuario().getNombre() : "Anónimo";
            resumen.put(nombre, resumen.getOrDefault(nombre, 0.0) + venta.getTotal());
        }
        return resumen;
    }
}
