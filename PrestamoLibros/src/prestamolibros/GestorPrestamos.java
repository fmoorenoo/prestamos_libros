package prestamolibros;

public class GestorPrestamos {

    public static synchronized boolean solicitarPrestamo(Libro libro1, Libro libro2, Estudiante estudiante) {
        if (!libro1.prestado && !libro2.prestado) {
            libro1.prestado = true;
            libro2.prestado = true;
            System.out.println("Se prestan los libros '" + libro1.getTipo() + "' y '" + libro2.getTipo() + "' a " + estudiante.getNombre() + ".");
            return true;
        }
        return false;
    }

    public static synchronized void liberarPrestamo(Libro libro1, Libro libro2, Estudiante estudiante) {
        libro1.prestado = false;
        libro2.prestado = false;
        System.out.println(estudiante.getNombre() + " devuelve los libros '" + libro1.getTipo() + "' y '" + libro2.getTipo() + "'.");
    }
}
