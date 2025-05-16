package botiga;

import producte.*;
import usuari.*;
import venda.*;
import utilitats.InputHelper;

import java.util.Map;
import java.util.Optional;

public class Main {

    private static GestorProductes gestorProductes = new GestorProductes();
    private static GestorUsuaris gestorUsuaris = new GestorUsuaris();
    private static GestorVendes gestorVendes = new GestorVendes();
    private static Usuari usuariActual = null;

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Agregar producto (admin)");
            System.out.println("4. Ver catálogo de productos");
            System.out.println("5. Realizar venta");
            System.out.println("6. Ver resumen de ventas");
            System.out.println("0. Salir");

            int opcion = InputHelper.readInteger();

            switch (opcion) {
            case 1:
                registrarUsuario();
                break;
            case 2:
                iniciarSesion();
                break;
            case 3:
                agregarProducto();
                break;
            case 4:
                gestorProductes.listarProductos();
                break;
            case 5:
                realizarVenta();
                break;
            case 6:
                verResumenVentas();
                break;
            case 0:
                continuar = false;
                System.out.println("¡Gracias por usar el sistema!");
                break;
            default:
                System.out.println("Opción no válida.");
        }

        }
    }

    private static void registrarUsuario() {
        Usuari nuevo = gestorUsuaris.crearUsuarioDesdeInput();
        if (gestorUsuaris.agregarUsuario(nuevo)) {
            System.out.println("Usuario registrado correctamente.");
        } else {
            System.out.println("Ya existe un usuario con ese correo.");
        }
    }

    private static void iniciarSesion() {
        System.out.println("\n=== Inicio de sesión ===");
        System.out.print("Correo: ");
        String correo = InputHelper.readEmail();

        System.out.print("Contraseña: ");
        String contrasena = InputHelper.readString();

        if (gestorUsuaris.validarCredenciales(correo, contrasena)) {
            usuariActual = gestorUsuaris.obtenerUsuario(correo);
            System.out.println("Bienvenido/a " + usuariActual.getNombre() + " (" + usuariActual.getRol() + ")");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private static void agregarProducto() {
        if (verificarAdmin()) {
            gestorProductes.agregarProductoDesdeInput();
        } else {
            System.out.println("Acceso denegado. Solo administradores pueden agregar productos.");
        }
    }

    private static void realizarVenta() {
    	if (gestorProductes.catalogoVacio()) {
    	    System.out.println("No hay productos disponibles para la venta.");
    	    return;
    	}

        Venda venta = new Venda(usuariActual);

        boolean agregarMas = true;
        while (agregarMas) {
            System.out.print("Nombre del producto: ");
            String nombre = InputHelper.readString();
            Optional<Producte> productoOpt = gestorProductes.buscarPorNombre(nombre);

            if (productoOpt.isPresent()) {
                venta.agregarLineaDesdeInput(productoOpt.get());
            } else {
                System.out.println("Producto no encontrado.");
            }

            System.out.print("¿Agregar otro producto? (s/n): ");
            String respuesta = InputHelper.readString().toLowerCase();
            agregarMas = respuesta.equals("s");
        }

        gestorVendes.registrarVenta(venta);
        System.out.println("\n=== Venta registrada ===");
        System.out.println(venta);
    }

    private static void verResumenVentas() {
        System.out.println("\n=== Resumen de ventas por producto ===");
        for (Map.Entry<String, Integer> entry : gestorVendes.resumenPorProducto().entrySet()) {
            System.out.printf("- %s: %d unidades vendidas%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\n=== Resumen de ventas por usuario ===");
        for (Map.Entry<String, Double> entry : gestorVendes.resumenPorUsuario().entrySet()) {
            System.out.printf("- %s: %.2f €%n", entry.getKey(), entry.getValue());
        }
    }

    private static boolean verificarAdmin() {
        return usuariActual != null && usuariActual.getRol() == Usuari.Rol.ADMINISTRADOR;
    }
}
