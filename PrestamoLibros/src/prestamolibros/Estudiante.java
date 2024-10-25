package prestamolibros;

import java.util.Random;

public class Estudiante implements Runnable {

    private String nombre;
    private Libro[] libros;
    private Random random = new Random();
    private int librosLeidos = 0;

    public Estudiante(String nombre, Libro[] libros) {
        this.nombre = nombre;
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        // El programa se ejecuta hasta que todos los estudiantes lean al menos 2 libros
        while (librosLeidos < 2) { 
            int libroIndex1 = random.nextInt(libros.length);
            int libroIndex2 = random.nextInt(libros.length);
            while (libroIndex1 == libroIndex2) {
                libroIndex2 = random.nextInt(libros.length);
            }

            Libro libro1 = libros[libroIndex1];
            Libro libro2 = libros[libroIndex2];

            int tiempoUso = random.nextInt(3) + 1; 
            int tiempoDescanso = random.nextInt(2) + 1;

            System.out.println(nombre + " quiere los libros de '" + libro1.getTipo() + "' y '" + libro2.getTipo() + "' durante " + tiempoUso + " hora(s) y luego descansará " + tiempoDescanso + " hora(s).");

            boolean prestamoCorrecto = false;
            while (!prestamoCorrecto) { 
                prestamoCorrecto = GestorPrestamos.solicitarPrestamo(libro1, libro2, this);
                if (!prestamoCorrecto) {
                    try {
                        Thread.sleep(50); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Thread.sleep(tiempoUso * 60); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GestorPrestamos.liberarPrestamo(libro1, libro2, this);
            librosLeidos++;

            try {
                Thread.sleep(tiempoDescanso * 60); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " ha terminado de leer sus 2 libros.");
    }
}
