package botiga;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorProductesTest {
    private List<ProducteTest> productes = new ArrayList<>();

    public void afegirProducte(ProducteTest p) {
        productes.add(p);
    }

    public boolean eliminarProducte(String nom) {
        return productes.removeIf(p -> p.getNom().equalsIgnoreCase(nom));
    }

    public Optional<ProducteTest> cercarProducte(String nom) {
        return productes.stream()
                        .filter(p -> p.getNom().equalsIgnoreCase(nom))
                        .findFirst();
    }

    public void aplicarDescompte(String nom, double percentatge) {
        cercarProducte(nom).ifPresent(p -> {
            double nouPreu = p.getPreu() * (1 - percentatge / 100);
            p.setPreu(nouPreu);
        });
    }

    public void mostrarProductes() {
        productes.forEach(System.out::println);
    }
}
