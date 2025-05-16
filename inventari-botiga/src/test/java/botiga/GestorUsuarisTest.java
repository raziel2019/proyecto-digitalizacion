package botiga;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usuari.GestorUsuaris;
import usuari.Usuari;

import static org.junit.jupiter.api.Assertions.*;

public class GestorUsuarisTest {

    private GestorUsuaris gestor;

    @BeforeEach
    public void setUp() {
        gestor = new GestorUsuaris();
        System.out.println("=== Nuevo GestorUsuaris creado ===");
    }

    @Test
    public void testAgregarYValidarUsuario() {
        System.out.println("=== testAgregarYValidarUsuario ===");
        Usuari u = new Usuari("Raciel", "raciel@test.com", "clave", Usuari.Rol.CLIENTE);
        boolean agregado = gestor.agregarUsuario(u);
        boolean valido = gestor.validarCredenciales("raciel@test.com", "clave");

        System.out.println("Usuario agregado: " + agregado);
        System.out.println("¿Credenciales válidas? " + valido);

        assertTrue(agregado);
        assertTrue(valido);
    }

    @Test
    public void testNoAgregarDuplicado() {
        System.out.println("=== testNoAgregarDuplicado ===");
        Usuari u1 = new Usuari("A", "correo@test.com", "123", Usuari.Rol.CLIENTE);
        Usuari u2 = new Usuari("B", "correo@test.com", "456", Usuari.Rol.ADMINISTRADOR);

        boolean primero = gestor.agregarUsuario(u1);
        boolean segundo = gestor.agregarUsuario(u2);

        System.out.println("¿Primer usuario agregado? " + primero);
        System.out.println("¿Segundo usuario duplicado agregado? " + segundo);

        assertTrue(primero);
        assertFalse(segundo);
    }
}
