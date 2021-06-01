package garciaSantiagoJulianP1PB2;

public abstract class Libro {
    private final String codigo;
    private final String nombre;
    private final String autor;
    private Prestamo prestamoActual;

    public Libro(String codigo, String nombre, String autor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.prestamoActual = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAutor() {
        return autor;
    }

    public Prestamo getPrestamoActual() {
        return prestamoActual;
    }

    public boolean sePuedePrestar() {
        return prestamoActual != null;
    }

    public void retirar(Prestamo prestamo) {
        prestamoActual = prestamo;
    }

    public void devolver() {
        prestamoActual = null;
    }

    public abstract String getTipoDeLibro();
}
