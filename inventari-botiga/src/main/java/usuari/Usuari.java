package usuari;

import utilitats.InputHelper;

public class Usuari {
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    private Rol rol;

    public enum Rol {
        ADMINISTRADOR,
        CLIENTE
    }

    public Usuari(String nombre, String correoElectronico, String contrasena, Rol rol) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public Rol getRol() {
        return rol;
    }

    public boolean validarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correoElectronico + '\'' +
                ", rol=" + rol +
                '}';
    }
}
