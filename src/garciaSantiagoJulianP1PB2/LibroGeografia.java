package garciaSantiagoJulianP1PB2;

public class LibroGeografia extends Libro implements Imprimible {

    public LibroGeografia(String codigo, String nombre, String autor) {
        super(codigo, nombre, autor);
    }

    @Override
    public String getTipoDeLibro() {
        return "Geografia";
    }

    @Override
    public String imprimir() {
        String informacion = "[" + getCodigo() + "] " + getNombre() + "(" + getAutor() + ") " + getTipoDeLibro();
        System.out.println(informacion);
        return informacion;
    }
}
