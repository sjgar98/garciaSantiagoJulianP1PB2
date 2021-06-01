package garciaSantiagoJulianP1PB2;

import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Libro> libros;
    private final ArrayList<Estudiante> estudiantes;
    private final ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList();
        this.estudiantes = new ArrayList();
        this.prestamos = new ArrayList();
    }

    public void registrarLibro(TipoDeLibro tipoDeLibro, String codigo, String nombre, String autor) {
        switch (tipoDeLibro) {
            case Historia:
                libros.add(new LibroHistoria(codigo, nombre, autor));
                break;
            case Geografia:
                libros.add(new LibroGeografia(codigo, nombre, autor));
                break;
            case Matematicas:
                libros.add(new LibroMatematicas(codigo, nombre, autor));
                break;
        }
    }

    public void registrarEstudiante(int documento, String nombre, String apellido) {
        estudiantes.add(new Estudiante(documento, nombre, apellido));
    }

    public boolean prestar(Libro libro, Estudiante estudiante) {
        if (estudiante.puedeRetirarLibros() && libro.sePuedePrestar()) {
            Prestamo nuevoPrestamo = new Prestamo(prestamos.size(), estudiante, libro);
            estudiante.retirarLibro(libro);
            libro.retirar(nuevoPrestamo);
            prestamos.add(nuevoPrestamo);
            return true;
        } else {
            return false;
        }
    }

    public boolean recuperar(Libro libro) {
        if (!libro.sePuedePrestar()) {
            Estudiante estudiante = libro.getPrestamoActual().getEstudiante();
            return estudiante.devolverLibro(libro);
        } else {
            return false;
        }
    }

    public boolean imprimir(Libro libro) {
        switch (libro.getTipoDeLibro()) {
            case "Historia":
            case "Geografia":
                // libro.imprimir();
                return true;
            default:
                return false;
        }
    }

}
