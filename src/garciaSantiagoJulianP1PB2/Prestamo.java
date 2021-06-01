package garciaSantiagoJulianP1PB2;

public class Prestamo {
    private final int indice;
    private final Estudiante estudiante;
    private final Libro libro;

    public Prestamo(int indice, Estudiante estudiante, Libro libro) {
        this.indice = indice;
        this.estudiante = estudiante;
        this.libro = libro;
    }

    public int getIndice() {
        return indice;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Libro getLibro() {
        return libro;
    }
}
