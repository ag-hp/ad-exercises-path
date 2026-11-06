package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.4
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LecturaCompletaYPorListaConNIO2 {

    public static void main(String[] args) {
        // Lectura completa con Files.readString
        Path ruta = Path.of("datos/mensaje.txt");

        try {
            // Lectura directa en UTF-8 a un único String
            String contenido = Files.readString(ruta, StandardCharsets.UTF_8);
            System.out.println("=== Contenido ===");
            System.out.println(contenido);
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }

        // Lectura a lista con Files.readAllLines
        Path ruta2 = Path.of("datos/alumnos.txt");

        try {
            // Lectura de todas las líneas a una lista
            List<String> lineas = Files.readAllLines(ruta2, StandardCharsets.UTF_8);
            System.out.println("Total líneas: " + lineas.size());
            for (int i = 0; i < lineas.size(); i++) {
                System.out.println("Línea " + (i + 1) + ": " + lineas.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error al leer lista: " + e.getMessage());
        }
    }
}