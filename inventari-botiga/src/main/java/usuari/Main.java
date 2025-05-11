public class Main {
    public static void main(String[] args) {
        GestorUsuaris gestor = new GestorUsuaris();

        Usuaris admin = new Usuaris("Anna", "anna@botiga.com", "1234", Usuaris.Rol.ADMINISTRADOR);
        Usuaris client = new Usuaris("Joan", "joan@botiga.com", "abcd", Usuaris.Rol.CLIENT);

        gestor.afegirUsuari(admin);
        gestor.afegirUsuari(client);

        if (gestor.validarCredencials("joan@botiga.com", "abcd")) {
            System.out.println("Login correcte per a Joan.");
        }

        if (gestor.esAdministrador("anna@botiga.com")) {
            System.out.println("Anna és administradora.");
        }

        gestor.llistarUsuaris();
    }
}