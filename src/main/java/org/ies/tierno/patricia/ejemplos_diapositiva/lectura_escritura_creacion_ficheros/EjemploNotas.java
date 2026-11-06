package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.10
// 1. Lectura y escritura rápida en UTF-8 (NIO.2)
import java.io.File;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class EjemploNotas {
    public static void main(String[] args) throws Exception {
        Path file = Path.of("nota.txt");

        // Escribir texto en UTF-8
        Files.writeString(file, "Comprar pan", StandardCharsets.UTF_8);

        // Leer texto completo
        String texto = Files.readString(file, StandardCharsets.UTF_8);
        System.out.println("Contenido: " + texto);

        // Opción A: API moderna (java.nio.file)
        Path path = Path.of("docs", "ejemplo.txt");
        Files.createDirectories(path.getParent());
        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        // Opción B: API clásica (java.io.File)
        File file2 = new File("docs/ejemplo.txt");
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        if (!file2.exists()) {
            file2.createNewFile();
        }
    }
}