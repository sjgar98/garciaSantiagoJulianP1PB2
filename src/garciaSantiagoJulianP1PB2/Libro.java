package garciaSantiagoJulianP1PB2;

public abstract class Libro implements Imprimible {
    private final String codigo;
    private final String nombre;
    private final String autor;
    private Prestamo prestamoActual;
    private boolean prestado;

    public Libro(String codigo, String nombre, String autor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.prestamoActual = null;
        this.prestado = false;
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
        return !prestado;
    }

    public void retirar(Prestamo prestamo) {
        prestamoActual = prestamo;
        prestado = true;
    }

    public void devolver() {
        prestamoActual = null;
        prestado = false;
    }

    public abstract String getTipoDeLibro();

    @Override
    public abstract String imprimir();
}
