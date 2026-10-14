package org.ies.tierno.manejando_ficheros.exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.Files.exists;

public class Archivos {

    // 1. Creamos ruta y vemos si existe
    public boolean existeFicheroIO(String nombreFichero) {
        File archivo = new File(nombreFichero);
        return archivo.exists();
    }

    public boolean existeFicheroNIO(String nombreFichero) {
        Path ruta = Path.of(nombreFichero);
        return Files.exists(ruta);
    }

    // 2.


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

        if (carpeta.isDirectory()){
            for(String nombre : carpeta.list()){
                System.out.println(nombre);
            }
            return false;
        }
        return true;
    }

    public boolean esDirectorioNIO(String ruta){
        Path carpeta = Path.of(ruta);

        if (Files.isDirectory(carpeta)){
            for (File archivo : carpeta.toFile().listFiles()){
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
    /*
    ¿Qué sucede si el fichero no existe?
     · En java.io (delete()): Devuelve false sin lanzar ninguna excepción.
     · En java.nio.file (deleteIfExists()): Devuelve false sin lanzar ninguna excepción. (Si se usara Files.delete(), lanzaría NoSuchFileException).
    Justificación de NIO
    Sí, se puede hacer en java.nio.file usando Files.deleteIfExists(path) o Files.delete(path). La diferencia es que NIO permite diferenciar entre
    un archivo que no existe (deleteIfExists devuelve false) y un error real de permisos o sistema mediante excepciones explícitas (AccessDeniedException,
    DirectoryNotEmptyException), a diferencia de java.io que solo devuelve false para cualquier fallo.
    */

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

    // 9.

    // 10.

    // 11.

    // 12.

    // 13.

    // 14.

    // 15.
}



