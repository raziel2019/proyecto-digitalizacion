public class Usuaris {
    private String nom;
    private String correuElectronic;
    private String contrasenya;
    private Rol rol;

    public enum Rol {
        ADMINISTRADOR,
        CLIENT
    }

    public Usuaris(String nom, String correuElectronic, String contrasenya, Rol rol) {
        this.nom = nom;
        this.correuElectronic = correuElectronic;
        this.contrasenya = contrasenya;
        this.rol = rol;
    }

    public String getNom() {
        return nom;
    }

    public String getCorreuElectronic() {
        return correuElectronic;
    }

    public Rol getRol() {
        return rol;
    }

    public boolean validarContrasenya(String contrasenya) {
        return this.contrasenya.equals(contrasenya);
    }

    @Override
    public String toString() {
        return "Usuari{" +
                "nom='" + nom + '\'' +
                ", correu='" + correuElectronic + '\'' +
                ", rol=" + rol +
                '}';
    }
}
