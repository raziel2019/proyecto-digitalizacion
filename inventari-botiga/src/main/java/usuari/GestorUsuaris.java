import java.util.HashMap;
import java.util.Map;

public class GestorUsuaris {
    private Map<String, Usuaris> usuaris;

    public GestorUsuaris() {
        usuaris = new HashMap<>();
    }

    public boolean afegirUsuari(Usuaris usuari) {
        if (usuaris.containsKey(usuari.getCorreuElectronic())) {
            return false;
        }
        usuaris.put(usuari.getCorreuElectronic(), usuari);
        return true;
    }

    public Usuaris obtenirUsuari(String correu) {
        return usuaris.get(correu);
    }

    public boolean validarCredencials(String correu, String contrasenya) {
        Usuaris usuari = usuaris.get(correu);
        if (usuari != null) {
            return usuari.validarContrasenya(contrasenya);
        }
        return false;
    }

    public boolean esAdministrador(String correu) {
        Usuaris usuari = usuaris.get(correu);
        return usuari != null && usuari.getRol() == Usuaris.Rol.ADMINISTRADOR;
    }

    public void llistarUsuaris() {
        for (Usuaris usuari : usuaris.values()) {
            System.out.println(usuari);
        }
    }
}
