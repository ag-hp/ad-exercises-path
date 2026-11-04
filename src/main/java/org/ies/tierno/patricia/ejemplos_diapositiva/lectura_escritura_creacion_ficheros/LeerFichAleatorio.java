package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("Aleatorio.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int id, departamentos;
        double salarios;
        char apellidos[] = new char[10];
        char letra;
        int posicion = 0; // Para situarnos al principio

        while (file.getFilePointer() < file.length()) {
            file.seek(posicion); // Nos posicionamos en el
            id = file.readInt();

            //  Recorro uno a uno los caracteres del apellido
            for (int i = 0; i < apellidos.length; i++) {
                letra = file.readChar();
                apellidos[i] = letra;
            }
        }
        file.close();
    }
}
