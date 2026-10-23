package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

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
    }
}