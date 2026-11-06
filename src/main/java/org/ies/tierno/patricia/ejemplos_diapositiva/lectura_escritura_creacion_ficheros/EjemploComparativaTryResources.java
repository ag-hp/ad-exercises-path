package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.12
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EjemploComparativaTryResources {
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            br = Files.newBufferedReader(Path.of("datos.txt"));
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        } finally {
            // Es obligatorio cerrar manualmente
            // y controlar que no sea null
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar: " + e.getMessage());
                }
            }
        }

        // El recurso se declara e inicializa
        // entre los paréntesis del try
        try (BufferedReader br2 = Files.newBufferedReader(Path.of("datos.txt"))) {
            System.out.println(br2.readLine());
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
        // Al salir del bloque, Java ejecuta
    }
}