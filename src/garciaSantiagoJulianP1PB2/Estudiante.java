package garciaSantiagoJulianP1PB2;

import java.util.ArrayList;

public class Estudiante {
    private final int documento;
    private final String nombre;
    private final String apellido;
    private final ArrayList<Libro> librosRetirados;

    public Estudiante(int documento, String nombre, String apellido) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.librosRetirados = new ArrayList();
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean puedeRetirarLibros() {
        return librosRetirados.size() < 2;
    }

    public boolean retirarLibro(Libro libro) {
        if (puedeRetirarLibros()) {
            librosRetirados.add(libro);
            return true;
        } else {
            return false;
        }
    }

    public boolean devolverLibro(Libro libro) {
        if (librosRetirados.contains(libro)) {
            libro.devolver();
            librosRetirados.remove(libro);
            return true;
        } else {
            return false;
        }
    }

}
