package usuari;

import java.util.HashMap;
import java.util.Map;
import utilitats.InputHelper;

public class GestorUsuaris {
    private Map<String, Usuari> usuarios;

    public GestorUsuaris() {
        usuarios = new HashMap<>();
    }

    public boolean agregarUsuario(Usuari usuario) {
        if (usuarios.containsKey(usuario.getCorreoElectronico())) {
            return false;
        }
        usuarios.put(usuario.getCorreoElectronico(), usuario);
        return true;
    }

    public Usuari crearUsuarioDesdeInput() {
        System.out.println("\n=== Registro de nuevo usuario ===");
        String nombre = InputHelper.readString();
        System.out.print("Correo electrónico: ");
        String correo = InputHelper.readEmail();
        System.out.print("Contraseña: ");
        String contrasena = InputHelper.readString();

        System.out.print("Rol (1 = ADMINISTRADOR, 2 = CLIENTE): ");
        int rolSeleccionado = InputHelper.readPositiveInteger();
        Usuari.Rol rol = rolSeleccionado == 1 ? Usuari.Rol.ADMINISTRADOR : Usuari.Rol.CLIENTE;

        return new Usuari(nombre, correo, contrasena, rol);
    }

    public Usuari obtenerUsuario(String correo) {
        return usuarios.get(correo);
    }

    public boolean validarCredenciales(String correo, String contrasena) {
        Usuari usuario = usuarios.get(correo);
        if (usuario != null) {
            return usuario.validarContrasena(contrasena);
        }
        return false;
    }

    public boolean esAdministrador(String correo) {
        Usuari usuario = usuarios.get(correo);
        return usuario != null && usuario.getRol() == Usuari.Rol.ADMINISTRADOR;
    }

    public void listarUsuarios() {
        for (Usuari usuario : usuarios.values()) {
            System.out.println(usuario);
        }
    }
}
