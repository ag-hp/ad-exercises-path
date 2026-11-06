package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.16
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MovimientoAtomicoDeUnFichero {
    public static void main(String[] args) {
        // Movimiento atómico de un fichero
        Path origen = Path.of("datos/archivo.txt");
        Path destino = Path.of("copia/archivo.txt");
        try {
            Files.move(origen, destino, StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException e) {
            System.err.println("Error al mover: " + e.getMessage());
        }
    }
}