package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.14
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class BusquedaPorPredicadosYRecorridoDFS {
    public static void main(String[] args) {

        // Búsqueda por metadatos con Files.find
        Path raiz = Path.of("servidor/logs");
        long limiteBytes = 1024 * 1024; // 1 MB

        // Files.find filtra por atributos en tiempo de exploración
        try (Stream<Path> resultados = Files.find(
                raiz, Integer.MAX_VALUE,
                (path, attrs) -> attrs.isRegularFile() && attrs.size() >= limiteBytes
        )) {
            resultados.forEach(f -> System.out.println("Log pesado: " + f.getFileName()));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    // Recorrido recursivo manual DFS en java.io
    public static void explorar(File nodo) {
        File[] hijos = nodo.listFiles();
        if (hijos == null) return; // Control de seguridad

        for (File f : hijos) {
            if (f.isDirectory()) {
                System.out.println("[DIR] " + f.getAbsolutePath());
                explorar(f); // Llamada recursiva DFS
            } else {
                System.out.println(" [FILE] " + f.getName());
            }
        }
    }
}