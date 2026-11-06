package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

// P.17
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MetadatosConJavaIoFile {
    public static void main(String[] args) {
        // Metadatos con java.io.File
        File archivo = new File("datos/reporte.txt");

        System.out.println("Ruta absoluta: " +
                archivo.getAbsolutePath());
        System.out.println("¿Existe?: " + archivo.exists());
        System.out.println("¿Se puede leer?: " +
                archivo.canRead());

        long ms = archivo.lastModified();
        String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(ms));
        System.out.println("Última modificación: " + fecha);
    }
}