package venda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorVendes {
    private List<Venda> vendes;

    public GestorVendes() {
        this.vendes = new ArrayList<>();
    }

    public void registrarVenda(Venda venda) {
        vendes.add(venda);
    }

    public List<Venda> getVendes() {
        return vendes;
    }

    public Map<String, Integer> resumPerProducte() {
        Map<String, Integer> resum = new HashMap<>();
        for (Venda venda : vendes) {
            for (LiniaVenda linia : venda.getLinies()) {
                String nom = linia.getProducte().getNom();
                resum.put(nom, resum.getOrDefault(nom, 0) + linia.getQuantitat());
            }
        }
        return resum;
    }

    public Map<String, Double> resumPerUsuari() {
        Map<String, Double> resum = new HashMap<>();
        for (Venda venda : vendes) {
            String nom = venda.getUsuari() != null ? venda.getUsuari().getNom() : "Anònim";
            resum.put(nom, resum.getOrDefault(nom, 0.0) + venda.getTotal());
        }
        return resum;
    }
}
