package botiga;


import org.junit.jupiter.api.Test;

import usuari.Usuari;

import static org.junit.jupiter.api.Assertions.*;

public class UsuariTest {

    @Test
    public void testValidarContrasena() {
        System.out.println("=== testValidarContrasena ===");
        Usuari u = new Usuari("Juan", "juan@test.com", "1234", Usuari.Rol.CLIENTE);
        System.out.println("Usuario creado: " + u);

        boolean correcta = u.validarContrasena("1234");
        boolean incorrecta = u.validarContrasena("0000");
        System.out.println("¿Contraseña correcta? " + correcta);
        System.out.println("¿Contraseña incorrecta? " + incorrecta);

        assertTrue(correcta);
        assertFalse(incorrecta);
    }

    @Test
    public void testRolAsignado() {
        System.out.println("=== testRolAsignado ===");
        Usuari admin = new Usuari("Admin", "admin@test.com", "admin", Usuari.Rol.ADMINISTRADOR);
        System.out.println("Usuario creado: " + admin);

        assertEquals(Usuari.Rol.ADMINISTRADOR, admin.getRol());
    }
}
