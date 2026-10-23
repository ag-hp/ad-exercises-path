package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

import java.io.File;
import java.nio.file.*;

public class CreacionDirectoriosFicheros {
    public static void main(String[] args) throws Exception {

        // Opción A: API moderna (java.nio.file)
        Path path = Path.of("docs", "ejemplo.txt");
        Files.createDirectories(path.getParent());
        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        // Opción B: API clásica (java.io.File)
        File file = new File("docs/ejemplo.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}