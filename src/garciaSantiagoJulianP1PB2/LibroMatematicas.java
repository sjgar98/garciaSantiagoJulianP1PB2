package garciaSantiagoJulianP1PB2;

public class LibroMatematicas extends Libro {

    public LibroMatematicas(String codigo, String nombre, String autor) {
        super(codigo, nombre, autor);
    }

    @Override
    public String getTipoDeLibro() {
        return "Matematicas";
    }
}
