package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.16
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class VigilarCarpeta {
    public static void main(String[] args) throws Exception {
        // Uso de WatchService
        Path carpeta = Path.of("documentos");

        WatchService vigilante = FileSystems.getDefault().newWatchService();
        // Indicamos qué cambios queremos detectar
        carpeta.register(
                vigilante,
                StandardWatchEventKinds.ENTRY_CREATE
        );
        System.out.println("Vigilando la carpeta documentos...");

        // Esperamos a que ocurra un cambio
        WatchKey clave = vigilante.take();
        // Mostramos los archivos creados
        for (WatchEvent<?> evento : clave.pollEvents()) {
            // Procesar evento
        }
    }
}
