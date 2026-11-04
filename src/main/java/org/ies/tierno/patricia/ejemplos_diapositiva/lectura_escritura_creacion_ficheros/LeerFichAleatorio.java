package org.ies.tierno.patricia.ejemplos_diapositiva.lectura_escritura_creacion_ficheros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("Aleatorio.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int id, departamento;
        double salario;
        char apellido[] = new char[10];
        char letra;
        int posicion = 0; // Para situarnos al principio

        while (file.getFilePointer() < file.length()) {
            file.seek(posicion); // Nos posicionamos en el registro
            id = file.readInt();

            //  Recorro uno a uno los caracteres del apellido
            for (int i = 0; i < apellido.length; i++) {
                letra = file.readChar();
                apellido[i] = letra;
            }

            String apellidos = new String(apellido);
            departamento = file.readInt();
            salario = file.readDouble();

            if (id > 0){
                System.out.printf(
                        "ID: %s, Apellido: %s, Departamento %d, Salario: %.2f %n",
                        id, apellidos.trim(), departamento, salario
                );
            }
            // Me posiciono en el siguiente empleado (cada uno ocupa 36 bytes)
            posicion = posicion + 36;
        }
        file.close();
    }
}
