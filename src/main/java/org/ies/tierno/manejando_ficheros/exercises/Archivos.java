package org.ies.tierno.manejando_ficheros.exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.exists;

public class Archivos {

    // 1. Creamos ruta y vemos si existe
    public boolean existeFicheroIO(String nombreFichero) {
        File archivo = new File(nombreFichero);
        return archivo.exists();
    }

    // 2.
    public boolean existeFicheroNIO(String nombreFichero) {
        Path ruta = Path.of(nombreFichero);
        return Files.exists(ruta);
    }

    // 3.
    public boolean estarEnIO(String nombreFichero, String rutaDirectorio) {
        File archivo = new File(nombreFichero, rutaDirectorio);
        return archivo.exists();
    }

    public boolean estarEnNIO(String nombreFichero, String rutaDirectorio) {
        return exists(Path.of(nombreFichero, rutaDirectorio));
    }

    // 4.
    public boolean esDirectorioIO(String ruta) {
        File carpeta = new File(ruta);

        if (carpeta.isDirectory()) {
            for (String nombre : carpeta.list()) {
                System.out.println(nombre);
            }
            return false;
        }
        return true;
    }

    public boolean esDirectorioNIO(String ruta) {
        Path carpeta = Path.of(ruta);

        if (Files.isDirectory(carpeta)) {
            for (File archivo : carpeta.toFile().listFiles()) {
                System.out.println(archivo.getName());
            }
            return false;
        }
        return true;
    }

    // 5.
    public void mostrarInformacionIO(String nombreFichero) {
        File archivo = new File(nombreFichero);

        if (archivo.exists()) {
            System.out.println("Nombre: " + archivo.getName());
            System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
            System.out.println("Se puede leer: " + archivo.canRead());
            System.out.println("Tamaño: " + archivo.length() + " bytes");
            System.out.println("Es directorio: " + archivo.isDirectory());
        } else {
            System.out.println("El fichero no existe.");
        }
    }

    public void mostrarInformacionNIO(String nombreFichero) throws Exception {
        Path ruta = Path.of(nombreFichero);

        if (Files.exists(ruta)) {
            System.out.println("Nombre: " + ruta.getFileName());
            System.out.println("Ruta absoluta: " + ruta.toAbsolutePath());
            System.out.println("Se puede leer: " + Files.isReadable(ruta));
            System.out.println("Tamaño: " + Files.size(ruta) + " bytes");
            System.out.println("Es directorio: " + Files.isDirectory(ruta));
        } else {
            System.out.println("El fichero no existe.");
        }
    }

    // 6.
    // OPTION 1:
    // Se puede hacer con un string si creamos um nuevo fichero
    public boolean eliminarIO(String fichero) throws Exception {
        // fichero.delete(); se puede dejar también así
        File file = new File(fichero);
        return file.delete();
    }

    // OPTION 2:
    public boolean eliminarNIO(Path fichero) throws Exception {
        return Files.deleteIfExists(fichero);
    }

    // 7.
    public boolean crearFicheroIO(String nombreFichero) throws IOException {
        File fichero = new File(nombreFichero);
        return fichero.createNewFile();
    }

    public boolean crearFicheroNIO(String nombreFichero) throws IOException {
        Path fichero = Path.of(nombreFichero);
        if (!Files.exists(fichero)) {
            Files.createFile(fichero);
            return true;
        }
        return false;
    }

    // 8.
    public boolean borradoRecursivoIO(File fichero) {
        if (!fichero.exists()) return false;

        if (fichero.isDirectory()) {
            String[] hijos = fichero.list();
            if (hijos != null) {
                for (String nombre : hijos) {
                    if (!borradoRecursivoIO(new File(fichero, nombre))) {
                        return false;
                    }
                }
            }
        }

        System.out.println("Borrado: " + fichero);
        return fichero.delete();
    }

    public boolean borradoRecursivoNIO(Path ruta) throws IOException {
        // 1. Si no existe, no hace nada
        if (!Files.exists(ruta)) {
            return false;
        }

        // 2. Si es carpeta, borra lo hay que dentro
        if (Files.isDirectory(ruta)) {
            // Al ponerlo dentro de los paréntesis del try, Java lo cierra solo al terminar
            try (DirectoryStream<Path> contenidos = Files.newDirectoryStream(ruta)) {
                for (Path hijo : contenidos) {
                    borradoRecursivoNIO(hijo);
                }
            }
        }

        // 3. Borra el archivo o la carpeta ya vacía
        Files.delete(ruta);
        System.out.println("Borrado: " + ruta);

        return true;
    }

    // 9.
    // ¿A qué clase pertenecen los métodos mkdir y mkdirs? ¿Qué diferencia estos métodos?
    /*
        Pertenecen a la 'java.io.File'
        · mkdir(): Crea una sola carpeta. Si falta alguna carpeta intermedia de la ruta, falla.
        · mkdirs(): Crea la carpeta final y todas las carpetas intermedias que falten en el camino.
    */

    public boolean crearCarpetasIO(String ruta) {
        // mkdir
        File capetaUnica = new File(ruta + "/carpeta1");
        boolean resultMkdir = capetaUnica.mkdir();

        // mkdirs
        File carpetasTodas = new File(ruta + "/carpeta2/carpeta3/fichero.txt");
        boolean resultMkdirs = carpetasTodas.mkdirs();

        // Devuelve true solo si las dos salieron bien
        return resultMkdir && resultMkdirs;
    }

    // 10.
    public static boolean crearDirectorioIO(String nombreCarpeta) {
        File carpeta = new File(nombreCarpeta);
        return carpeta.mkdir();
    }

    public static Path crearDirectorioNIO(String nombreCarpeta) throws Exception {
        Path ruta = Paths.get(nombreCarpeta);
        return Files.createDirectory(ruta);
    }

    // 11.
    public static boolean crearDirectorioRutaInexistenteIO(String rutaCompleta) {
        File carpeta = new File(rutaCompleta);
        return carpeta.mkdirs();
    }

    public static Path crearDirectorioRutaInexistenteNIO(String rutaCompleta) throws Exception {
        Path ruta = Paths.get(rutaCompleta);
        return Files.createDirectories(ruta);
    }

    // 12.

    // 13.

    // 14.

    // 15.

    // 16.
}



