package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.13
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.stream.Stream;

public class ListadoDirectoYFiltradoPorSintaxisGlob {
    public static void main(String[] args) {

        // Listado del nivel actual con Files.list
        Path directorio = Path.of("datos");

        // Listado no recursivo del nivel actual
        try (Stream<Path> contenido = Files.list(directorio)) {
            contenido.forEach(elem -> System.out.println("Elemento: " + elem.getFileName()));
        } catch (IOException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }

        // Filtrado recursivo con patrones Glob
        Path raiz = Path.of("proyectos");
        // Patrón Glob para buscar .txt en cualquier profundidad
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**//*.txt");

        try (Stream<Path> arbol = Files.walk(raiz)) {
            arbol.filter(p -> Files.isRegularFile(p) && matcher.matches(p))
                    .forEach(txt -> System.out.println("TXT: " + txt.toAbsolutePath()));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
