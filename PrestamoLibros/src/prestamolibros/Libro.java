package prestamolibros;

public class Libro {

    String id;
    String tipo;
    Boolean prestado;

    public Libro(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        this.prestado = false;
    }

    public String getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }
    
    public Boolean Prestar() {
        this.prestado = true;
        return this.prestado;
    }
    
    public Boolean Devolver() {
        this.prestado = false;
        return this.prestado;
    }
    
    
}

