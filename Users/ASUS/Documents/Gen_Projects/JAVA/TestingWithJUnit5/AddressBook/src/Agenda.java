
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Agenda {

    private Map<String, Contacto> contactos = new TreeMap<>();
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();

    public void agregarContacto(Contacto c) {
        if (contactos.containsKey(c.getNombre())) {
            System.out.println("Error: Ya existe un contacto con el nombre '" + c.getNombre() + "'");
            return;
        }

        contactos.put(c.getNombre(), c);
        historial.add(c);
        System.out.println("Contacto agregado: " + c.getNombre());
    }

    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre) {
        Contacto eliminado = contactos.remove(nombre);
        if (eliminado == null) {
            return false;
        }

        historial.remove(eliminado);
        for (Set<String> miembros : contactosPorGrupo.values()) {
            miembros.remove(nombre);
        }
        return true;
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados");
            return;
        }
        for (Contacto contacto : contactos.values()) {
            System.out.println(contacto);
        }
    }

    public void listarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial esta vacio");
            return;
        }
        for (Contacto contacto : historial) {
            System.out.println(contacto);
        }
    }

    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' ya existe");
            return;
        }

        grupos.add(nombreGrupo);
        contactosPorGrupo.put(nombreGrupo, new TreeSet<>());
        System.out.println("Grupo '" + nombreGrupo + "' creado");
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto '" + nombreContacto + "' no existe");
            return;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }

        boolean agregado = contactosPorGrupo.get(nombreGrupo).add(nombreContacto);
        if (agregado) {
            System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'");
        } else {
            System.out.println("El contacto ya pertenece al grupo '" + nombreGrupo + "'");
        }
    }

    public void listarGrupos() {
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos registrados");
            return;
        }
        for (String grupo : grupos) {
            System.out.println(grupo);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }

        Set<String> nombres = contactosPorGrupo.get(nombreGrupo);
        if (nombres.isEmpty()) {
            System.out.println("El grupo '" + nombreGrupo + "' no tiene contactos");
            return;
        }

        System.out.println("Contactos en '" + nombreGrupo + "':");
        for (String nombre : nombres) {
            System.out.println("- " + contactos.get(nombre));
        }
    }
}
