import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private LocalDateTime data;
    private Usuari usuari;
    private List<LiniaVenda> linies;

    public Venda(Usuari usuari) {
        this.data = LocalDateTime.now();
        this.usuari = usuari;
        this.linies = new ArrayList<>();
    }

    public void afegirLinia(Producte producte, int quantitat) {
        linies.add(new LiniaVenda(producte, quantitat));
    }

    public double getTotal() {
        return linies.stream().mapToDouble(LiniaVenda::getSubtotal).sum();
    }

    public LocalDateTime getData() {
        return data;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public List<LiniaVenda> getLinies() {
        return linies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ").append(data).append("\n");
        sb.append("Usuari: ").append(usuari != null ? usuari.getNom() : "Anònim").append("\n");
        for (LiniaVenda linia : linies) {
            sb.append(linia).append("\n");
        }
        sb.append("Total: ").append(getTotal());
        return sb.toString();
    }
}
