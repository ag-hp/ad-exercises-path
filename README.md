<h1 align="center">ACCESO A DATOS - RUTAS</h1>

<div align="center">
  <a href="https://www.java.com/"><img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white" alt="Java"></a>
  &nbsp;
  <a href="https://www.jetbrains.com/idea/"><img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=flat&logo=intellij-idea&logoColor=white" alt="IntelliJ IDEA"></a>
  &nbsp;
  <a href="LICENSE"><img src="https://img.shields.io/badge/License-Educational-blue?style=flat" alt="Educational License"></a>
  &nbsp;
  <a href="#"><img src="https://img.shields.io/badge/Ejercicios-Rutas-orange?style=flat" alt="Ejercicios Rutas"></a>
  &nbsp;
  <img src="https://img.shields.io/badge/Estado-Completado-brightgreen?style=flat" alt="Completado">
</div>

<br>

<h2>APIs manejo de ficheros Archivo</h2>

| Operación / Categoría | API clásica: File (java.io) | API moderna: Path y Files (java.nio.file) |
| :--- | :--- | :--- |
| **Creación de la ruta** | `new File(String path)` | `Path.of(...)` ó `Paths.get(...)` |
| **Obtención del nombre** | `getName()` | `getFileName()` |
| **Obtención de ruta absoluta** | `getAbsolutePath()` | `toAbsolutePath()` |
| **Normalización de ruta** | `getCanonicalPath()` | `normalize()` / `toRealPath()` |
| **Creación de directorios** | `mkdir()` / `mkdirs()` | `Files.createDirectory()` / `createDirectories()` |
| **Comprobación de tipo y estado** | `isFile()` / `isDirectory()` / `exists()` | `Files.isRegularFile()` / `isDirectory()` / `exists()` |
| **Creación de fichero vacío** | `createNewFile()` | `Files.createFile(path)` |

---

<h3>Utiliza las Apis de NIO e IO para resolver cada uno de los ejercicios y compara los resultados.</h3>

<h4>1. Codifica un método que cree los siguientes archivos:</h4>

  - `/tmp/acceso/introduccion.txt`
  - `/tmp/otro/ejemplo.txt`
  - `acceso/introduccion.txt`
  - `otro/ejemplo.txt`

<h4>2. Codifica un método que muestre las rutas absolutas de los siguientes archivos:</h4>

  - `/tmp/acceso/introduccion.txt`
  - `/tmp/otro/ejemplo.txt`
  - `acceso/introduccion.txt`
  - `otro/ejemplo.txt`

---

<h3>Manejando Ficheros</h3>

<p>Aquí os dejo una lista de los métodos más usados de de la clase File…</p>

<!-- Poner imagen aquí -->
<p align="center">
  
</p>
  <img width="1483" height="853" alt="chuleta_mtodos_clase_file" src="https://github.com/user-attachments/assets/0e93f530-d4fd-4f3b-8007-cf4983be155d" />
<br>

---

<h4>1. Consulta la API de la clase File, localiza el método exists y codifica un método que devuelva un valor booleano que indique si un determinado fichero está presente en la carpeta actual.</h4>

<p>El nombre del fichero que queremos localizar se le pasa como parámetro al método que tú tienes que localizar.</p>

<p>Codifica también lo necesario para probar este método (sólo el <code>main</code> puede ser estático).</p>

---

<h4>2. Ahora, en lugar de mirar en el directorio actual, tienes que codificar un método que te diga si un determinado fichero pasado como parámetro está presente dentro de un directorio también pasado como parámetro. Llama a este método "estaEn".</h4>

<p>Escribe también el código necesario para poder probar el citado método.</p>

---

<h4>3. Repite los ejercicios 1 y 2 utilizando las clases del paquete java.nio.files (necesitarás las interfaces Path y Files).</h4>

<p><em>Sugerencia: para empezar, apóyate en el ejemplo de manejo de NIO que estudiamos en clase</em></p>

---

<h4>4. Crea un método que te diga si un determinado fichero pasado como parámetro es un directorio.</h4>

- En caso afirmativo devolverá true y, adicionalmente, mostrará por consola los ficheros que contiene (es decir, funcionaría como un ls o un dir). Resuélvelo tanto utilizando las clases del paquete java.io como usando las clases del paquete java.nio.file y compara las soluciones.

---

<h4>5. Escribir el código necesario para mostrar por consola la siguiente información de un fichero que se le pasa a través de la línea de comandos (comprobar primero que el fichero está presente en el directorio en el que estamos):</h4>

- Nombre
- Ruta absoluta
- Se puede leer
- Tamaño
- Decir si se trata de directorio o de un fichero

<p>Resuélvelo tanto utilizando las clases del paquete java.io como usando las clases del paquete java.nio.file y compara las soluciones.</p>

---

<h4>6. Consulta el API de la clase File y programa un ejemplo de eliminación de un fichero pasado como parámetro. ¿Qué sucede si el fichero que se le pasa como parámetro en realidad no existe? ¿Se puede hacer esto mismo utilizando las clases del paquete java.nio.file? Justifica tu respuesta.</h4>

- [TestGestorFicheros.java.pdf](https://github.com/user-attachments/files/33155171/TestGestorFicheros.java.pdf)
- [GestorFicheros.java.pdf](https://github.com/user-attachments/files/33155331/GestorFicheros.java.pdf)

---

<h4>7. Utilizando tanto la api java.io como java.nio.file codifica un ejemplo de creación de un fichero en tu sistema de archivos.</h4>

---

<h4>8. Programa un ejemplo de la eliminación de un directorio que no está vacío, sino que contiene un directorio, que a su vez contiene algunos archivos (que previamente habrás colocado allí para eliminarlos después).</h4>

<p>El método debería ser capaz de eliminar la estructura completa, es decir, le pasamos como parámetro un directorio y es capaz de eliminar todos los subdirectorios y sus contenidos. (SE SUGIERE REALIZAR LOS EJERCICIOS DE ELIMINACIÓN DE FICHEROS O DIRECTORIOS SOBRE UNA MÁQUINA VIRTUAL PARA EVITAR ACCIDENTES)</p>

---

<h4>9. ¿A qué clase pertenecen los métodos mkdir y mkdirs? ¿Qué diferencia estos métodos?</h4>

---

<h4>10. Programa un ejemplo de creación de un directorio en la ruta actual usando tanto io como nio.</h4>

---

<h4>11. Programa un ejemplo de creación de un directorio en una determinada ruta que no existe. (Es decir, la ruta que nos dan para que creemos el directorio dentro no existe) Prueba qué sucede en este caso.</h4>

---

<h4>12. Observa en las diapositivas de la parte 1 de esta unidad algunas de las clases de excepciones que ofrece Java para la E/S. Modifica el código de los ejercicios anteriores para tratar las distintas excepciones de un modo específico (por ejemplo, ahora en vez de capturar IOException capturarías de forma separada FileAlreadyExistsException)</h4>

---

<h4>13. Investiga en qué consiste el try with resources. ¿En qué versión de java apareció esta estructura de control? Codifica y prueba los ejemplos de try y try with resources que se muestran en las diapositivas. ¿Qué ventajas e inconvenientes encuentras?</h4>

---

<h4>14. Hemos visto en este tema que la interfaz Path y la clase Files son inmutables. Explica con tus propias palabras el concepto de INMUTABILIDAD.</h4>

---

<h4>15. En parejas, comparte con tu compañer@ tu opinión sobre las buenas prácticas en la gestión de ficheros. ¿Añadirías o eliminarías alguna de ellas? ¿Por qué? Ordénalas de la más importante a la menos importante según tu criterio. Si sólo pudieras asegurar el cumplimiento de una de esas buenas prácticas ¿cuál elegirías y por qué? Discute y defiende tu elección frente a tu compañer@.</h4>

---

<h4>16. Codifica una clase llamada ReadTextFile con un main que:</h4>

1. Pida al usuario la ruta de un archivo
2. Lea el contenido de ese archivo y lo muestre en pantalla
3. Si el archivo no existe (se producirá la excepción FileNotFoundException (IO) o NoSuchFileException (NIO)), muestra el texto "Archivo no encontrado"
4. En caso de que se produzca alguna otra excepción durante la ejecución del programa, muestra el error "Error de E/S" junto con la stackTrace

---

<h3>Ejercicios de lectura y escritura de ficheros</h3>

<h4>Ejercicio 1</h4>

<p>Codificar la clase MaquinaDeEscribir. Debe tener un método que reciba un array de cadenas de caracteres y deposite su contenido a un fichero cuyo nombre recibe por parámetro. Las cadenas quedarán separadas en el archivo por un asterisco.</p>

<p>Realizar un tratamiento de de excepciones adecuado.</p>

---

<h4>Ejercicio 2</h4>

<p>Añadir a la clase anterior un método que reciba por parámetro el nombre de un archivo e imprima en pantalla las cadenas que dicho archivo contiene (una cadena por línea). Se tendrá en cuenta que las distintas cadenas están separadas en el archivo por un asterisco (que no se imprimirá).</p>

<p>Realizar un tratamiento de de excepciones adecuado.</p>

---

<p align="center">
  <a href="https://github.com/ag-hp/dam.git"><img src="https://img.shields.io/badge/VER_REPOSITORIO_COMPLETO-DESARROLLO_DE_APLICACIONES_MULTIPLATAFORMA-238636?style=for-the-badge&logo=github&logoColor=white&labelColor=000000" alt="Ver Repositorio Completo Desarrollo de Aplicaciones Multiplataforma"></a>
</p>
