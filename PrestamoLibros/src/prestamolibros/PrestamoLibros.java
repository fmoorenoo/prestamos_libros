package prestamolibros;

public class PrestamoLibros {

    public static int NUMERO_LIBROS = 9;
    public static int NUMERO_ESTUDIANTES = 4;

    public static void main(String[] args) {
        // Crear tres libros
        Libro libros[] = new Libro[NUMERO_LIBROS];
        libros[0] = new Libro("1", "La Biblia");
        libros[1] = new Libro("2", "Mates");
        libros[2] = new Libro("3", "Lengua");
        libros[3] = new Libro("4", "Diccionario");
        libros[4] = new Libro("5", "Ciencias");
        libros[5] = new Libro("6", "El patito feo");
        libros[6] = new Libro("7", "Historia");
        libros[7] = new Libro("8", "Guia Fortnite");  
        libros[8] = new Libro("9", "Instrucciones de Lego");        

        // Crear dos estudiantes
        Thread estudiantes[] = new Thread[NUMERO_ESTUDIANTES];
        estudiantes[0] = new Thread(new Estudiante("Fer", libros));
        estudiantes[1] = new Thread(new Estudiante("Fabio", libros));
        estudiantes[2] = new Thread(new Estudiante("Iriem", libros));
        estudiantes[3] = new Thread(new Estudiante("Unai", libros));

        // Lanzar los estudiantes
        for (Thread estudiante : estudiantes) {
            estudiante.start();
        }

        // Esperar a que todos los estudiantes terminen
        for (Thread estudiante : estudiantes) {
            try {
                estudiante.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Todos los estudiantes han terminado de leer al menos 2 libros.");
    }
}
