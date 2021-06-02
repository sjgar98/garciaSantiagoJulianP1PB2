package garciaSantiagoJulianP1PB2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {
    Biblioteca biblioteca;

    @Before
    public void crearBiblioteca() {
        biblioteca = new Biblioteca();
    }

    @Test
    public void debeRegistrarUnEstudiante() {
        Estudiante nuevoEstudiante = biblioteca.registrarEstudiante(35480541, "Fernando", "Duque");
        assertNotNull("Debe crear un estudiante", nuevoEstudiante);
        assertEquals("Debe agregar el estudiante a la biblioteca", 1, biblioteca.getCantidadDeEstudiantes());
    }

    @Test
    public void debeRegistrarUnLibro() {
        Libro nuevoLibro = biblioteca.registrarLibro(TipoDeLibro.Historia, "HI01", "Maten a Duarte", "Catalina De Elia");
        assertNotNull("Debe crear un libro", nuevoLibro);
        assertEquals("Debe agregar el libro a la biblioteca", 1, biblioteca.getCantidadDeLibros());
    }

    @Test
    public void debeGenerarUnPrestamo() {
        Estudiante estudiante = biblioteca.registrarEstudiante(35480541, "Fernando", "Duque");
        Libro libro = biblioteca.registrarLibro(TipoDeLibro.Historia, "HI01", "Maten a Duarte", "Catalina De Elia");
        boolean pudoPrestar = biblioteca.prestar(libro, estudiante);
        assertTrue("Pudo prestar correctamente", pudoPrestar);
        assertEquals("Se agrego el prestamo a la base de datos", 1, biblioteca.getCantidadDePrestamosTotales());
    }

    @Test
    public void noDebePrestarMasDeDosLibros() {
        Estudiante estudiante = biblioteca.registrarEstudiante(35000500, "Jorge", "Calvo");
        Libro libroUno = biblioteca.registrarLibro(TipoDeLibro.Geografia, "GE01", "Prisoners of Geography", "Tim Marshall");
        Libro libroDos = biblioteca.registrarLibro(TipoDeLibro.Historia, "HI01", "Maten a Duarte", "Catalina De Elía");
        Libro libroTres = biblioteca.registrarLibro(TipoDeLibro.Matematicas, "MA01", "Matematica Moderna 1", "Antonio Roberto López");
        biblioteca.prestar(libroUno, estudiante);
        biblioteca.prestar(libroDos, estudiante);
        boolean pudoPrestar = biblioteca.prestar(libroTres, estudiante);
        assertFalse("No debe poder prestar un tercer libro", pudoPrestar);
    }

    @Test
    public void noDebePrestarLibroYaPrestado() {
        Estudiante estudianteUno = biblioteca.registrarEstudiante(40000000, "Juan", "Perez");
        Estudiante estudianteDos = biblioteca.registrarEstudiante(35000500, "Jorge", "Calvo");
        Libro libro = biblioteca.registrarLibro(TipoDeLibro.Geografia, "GE01", "Prisoners of Geography", "Tim Marshall");
        biblioteca.prestar(libro, estudianteUno);
        boolean pudoPrestar = biblioteca.prestar(libro, estudianteDos);
        assertFalse("No debe poder prestar un libro ya prestado", pudoPrestar);
    }

    @Test
    public void puedeRecuperarLibroPrestado() {
        Estudiante estudiante = biblioteca.registrarEstudiante(35480541, "Fernando", "Duque");
        Libro libro = biblioteca.registrarLibro(TipoDeLibro.Historia, "HI01", "Maten a Duarte", "Catalina De Elia");
        biblioteca.prestar(libro, estudiante);
        boolean pudoRecuperar = biblioteca.recuperar(libro);
        assertTrue("Debe poder recuperar un libro prestado", pudoRecuperar);
    }

    @Test
    public void noDebePoderRecuperarUnLibroNoPrestado() {
        Libro libro = biblioteca.registrarLibro(TipoDeLibro.Historia, "HI01", "Maten a Duarte", "Catalina De Elia");
        boolean pudoRecuperar = biblioteca.recuperar(libro);
        assertFalse("No debe poder recuperar un libro no prestado", pudoRecuperar);
    }

    @Test
    public void debePoderImprimirLibroHistoria() {
        Libro libro = biblioteca.registrarLibro(TipoDeLibro.Historia, "HI01", "Maten a Duarte", "Catalina De Elia");
        String impresion = biblioteca.imprimir(libro);
        assertNotNull("Debe poder imprimir libro de historia", impresion);
    }

    @Test
    public void noDebePoderImprimirLibroMatematicas() {
        Libro libro = biblioteca.registrarLibro(TipoDeLibro.Matematicas, "MA01", "Matematica Moderna 1", "Antonio Roberto López");
        String impresion = biblioteca.imprimir(libro);
        assertNull("No debe poder imprimir libro de matematicas", impresion);
    }


}