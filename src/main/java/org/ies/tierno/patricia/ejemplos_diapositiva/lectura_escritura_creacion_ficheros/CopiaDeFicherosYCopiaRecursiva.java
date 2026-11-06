package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.9
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import static java.nio.file.StandardCopyOption.*;

public class CopiaDeFicherosYCopiaRecursiva {
    public static void main(String[] args) {

        // Copia de un fichero con metadatos
        Path origen = Path.of("datos/documento.pdf");
        Path destino = Path.of("backup/documento_copia.pdf");

        try {
            Files.createDirectories(destino.getParent());
            // Copiar reemplazando y conservando metadatos
            Files.copy(origen, destino, REPLACE_EXISTING, COPY_ATTRIBUTES);
            System.out.println("Copia realizada con éxito.");
        } catch (IOException e) {
            System.err.println("Error al copiar: " + e.getMessage());
        }

        // Copia recursiva con Files.walk
        Path origDir = Path.of("proyecto");
        Path destDir = Path.of("copia/proyecto");

        try (Stream<Path> arbol = Files.walk(origDir)) {
            arbol.forEach(origenRuta -> {
                try {
                    Path destinoRuta = destDir.resolve(origDir.relativize(origenRuta));
                    if (Files.isDirectory(origenRuta))
                        Files.createDirectories(destinoRuta);
                    else Files.copy(origenRuta, destinoRuta, REPLACE_EXISTING, COPY_ATTRIBUTES);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            System.err.println("Error en copia recursiva: " + e.getMessage());
        }

    }
}
