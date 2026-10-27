
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion = 0;

        while (opcion != 10) {
            System.out.println("\n=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos (orden alfabetico)");
            System.out.println("5. Listar historial (orden de insercion)");
            System.out.println("6. Agregar grupo");
            System.out.println("7. Agregar contacto a grupo");
            System.out.println("8. Listar grupos");
            System.out.println("9. Mostrar contactos por grupo");
            System.out.println("10. Salir");
            System.out.println("==========================");
            System.out.print("Elige una opcion: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opcion invalida, intenta de nuevo");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- AGREGAR CONTACTO ---");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Contacto nuevo = new Contacto(nombre, telefono, email);
                    agenda.agregarContacto(nuevo);
                }
                case 2 -> {
                    System.out.print("Nombre a buscar: ");
                    String nombre = scanner.nextLine();
                    Contacto encontrado = agenda.buscarContacto(nombre);
                    if (encontrado == null) {
                        System.out.println("Contacto no encontrado: " + nombre);
                    } else {
                        System.out.println(encontrado);
                    }
                }
                case 3 -> {
                    System.out.print("Nombre a eliminar: ");
                    String nombre = scanner.nextLine();
                    if (agenda.eliminarContacto(nombre)) {
                        System.out.println("Contacto eliminado: " + nombre);
                    } else {
                        System.out.println("Contacto no encontrado: " + nombre);
                    }
                }
                case 4 -> {
                    System.out.println("\n--- LISTA DE CONTACTOS (orden alfabetico) ---");
                    agenda.listarContactos();
                }
                case 5 -> {
                    System.out.println("\n--- HISTORIAL (orden de insercion) ---");
                    agenda.listarHistorial();
                }
                case 6 -> {
                    System.out.print("Nombre del grupo: ");
                    String grupo = scanner.nextLine();
                    agenda.agregarGrupo(grupo);
                }
                case 7 -> {
                    System.out.print("Nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Nombre del grupo: ");
                    String grupo = scanner.nextLine();
                    agenda.agregarContactoAGrupo(nombre, grupo);
                }
                case 8 -> {
                    System.out.println("\n--- GRUPOS (orden alfabetico) ---");
                    agenda.listarGrupos();
                }
                case 9 -> {
                    System.out.print("Nombre del grupo: ");
                    String grupo = scanner.nextLine();
                    agenda.mostrarContactosPorGrupo(grupo);
                }
                case 10 -> System.out.println("Saliendo de la agenda...");
                default -> System.out.println("Opcion invalida, intenta de nuevo");
            }
        }

        scanner.close();
    }
}
