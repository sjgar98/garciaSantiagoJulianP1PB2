package garciaSantiagoJulianP1PB2;

public class LibroHistoria extends Libro {

    public LibroHistoria(String codigo, String nombre, String autor) {
        super(codigo, nombre, autor);
    }

    @Override
    public String getTipoDeLibro() {
        return "Historia";
    }

    @Override
    public String imprimir() {
        String informacion = "[" + getCodigo() + "] " + getNombre() + "(" + getAutor() + ") " + getTipoDeLibro();
        System.out.println(informacion);
        return informacion;
    }
}
