package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFichAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        String apellidos[] = {"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"};

        int departamentos[] = {10, 20, 10, 10, 30, 30, 20};
        double salarios[] = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};

        StringBuffer buffer = null;
        int n = apellidos.length;

        for (int i = 0; i < n; i++) {
            file.writeInt(i + 1); // ID de empleado
            buffer = new StringBuffer(apellidos[i]);
            buffer.setLength(10); // Fijar exactamente los 10 carácteres
            file.writeChars(buffer.toString());
            file.writeInt(departamentos[i]);
            file.writeDouble(salarios[i]);
        }
        file.close();
    }
}
