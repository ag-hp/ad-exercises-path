package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.17
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class MetadatosEnBloqueConNIO2 {
    public static void main(String[] args) {
        // Metadatos en bloque con NIO.2
        Path ruta = Path.of("datos/reporte.txt");
        try {
            BasicFileAttributes attrs = Files.readAttributes(
                    ruta,
                    BasicFileAttributes.class
            );
            System.out.println("Creación: " +
                    attrs.creationTime());
            System.out.println("Modificación: " +
                    attrs.lastModifiedTime());
            System.out.println("¿Es directorio?: " +
                    attrs.isDirectory());
            System.out.println("Tamaño bytes: " + attrs.size());
        } catch (IOException e) {
            System.err.println("Error al leer metadatos: " + e.getMessage());
        }
    }
}