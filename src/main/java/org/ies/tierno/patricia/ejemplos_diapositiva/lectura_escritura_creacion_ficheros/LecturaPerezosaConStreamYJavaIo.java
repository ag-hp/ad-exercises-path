package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.5
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LecturaPerezosaConStreamYJavaIo {
    public static void main(String[] args) {

        // Lectura perezosa con Stream
        Path ruta = Path.of("datos/log_gigante.log");

        // Stream dentro del try-with-resources para
        // cerrar el canal
        try (Stream<String> lineas = Files.lines(ruta, StandardCharsets.UTF_8)) {
            lineas.filter(linea -> linea.contains("ERROR"))
                    .forEach(linea -> System.out.println("-> " + linea));
        } catch (IOException e) {
            System.err.println("Error en stream: " + e.getMessage());
        }

        // Lectura clásica en UTF-8
        File archivo = new File("datos/notas.txt");

        try (FileInputStream fis = new FileInputStream(archivo);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("> " + linea);
            }
        } catch (IOException e) {
            System.err.println("Error lectura clásica: " + e.getMessage());
        }
    }
}
