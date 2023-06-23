package excepciones;

public class excepcionFaltaDatos extends RuntimeException {
    public excepcionFaltaDatos() {
        super("Te faltan datos por llenar.");
    }
}
