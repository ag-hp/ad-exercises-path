package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.7
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.*;

public class EscrituraAnexadoYFormatoConPrintWriter {
    public static void main(String[] args) {

        // Anexado con StandardOpenOption
        Path ruta = Path.of("salida/traza.log");

        try {
            Files.createDirectories(ruta.getParent());
            String log = "INFO [" +
                    System.currentTimeMillis() + "] Evento registrado\n";

            // Opciones CREATE y APPEND combinadas
            Files.writeString(ruta, log,
                    StandardCharsets.UTF_8, CREATE, APPEND);
            System.out.println("Entrada anexada con éxito.");
        } catch (IOException e) {
            System.err.println("Error al anexar: " +
                    e.getMessage());
        }

        // Formato con PrintWriter en UTF-8
        File archivo = new File("salida/factura.txt");
        archivo.getParentFile().mkdirs();

        try (FileOutputStream fos = new
                FileOutputStream(archivo, false);
             OutputStreamWriter osw = new
                     OutputStreamWriter(fos, StandardCharsets.UTF_8);
             PrintWriter pw = new PrintWriter(osw)) {

            pw.println("=== FACTURA DE COMPRA ===");
            pw.printf("Producto: %-15s | Precio: %6.2f €%n",
                    "Teclado RGB", 45.99);
            System.out.println("Reporte generado.");
        } catch (IOException e) {
            System.err.println("Error en factura: " +
                    e.getMessage());
        }

    }
}
