package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.11
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.*;

public class MovimientoAtomicoBorradoSeguroYTransferTo {
    public static void main(String[] args) {

        // Movimiento atómico (Ejemplo 4.3)
        Path origen = Path.of("datos/temporal.tmp");
        Path destino = Path.of("procesados/definitivo.dat");

        try {
            Files.createDirectories(destino.getParent());
            // Transacción indivisible
            Files.move(origen, destino, ATOMIC_MOVE, REPLACE_EXISTING);
            System.out.println("Archivo movido atómicamente.");
        } catch (IOException e) {
            System.err.println("Error al mover: " + e.getMessage());
        }

        // Copia por flujos con transferTo (Ejemplo 4.5)
        File origenFile = new File("datos/imagen.png");
        File destinoFile = new File("backup/imagen.png");

        try (InputStream in = new BufferedInputStream(new FileInputStream(origenFile));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(destinoFile))) {

            // Transferencia eficiente directa introducida en Java 9+
            in.transferTo(out);
            System.out.println("Copia realizada con transferTo.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
