import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class ExploradorFicheros {
    public static void main(String[] args) {

        Path carpeta = Paths.get("datos/demo");

        try {
            Files.createDirectories(carpeta);
        } catch (IOException e) {
            System.err.println("Error al crear la carpeta");
        }

        Path archivo = carpeta.resolve("saludo.txt");

        try {
            Files.write(archivo, List.of("Hola, Bienvenidos"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo");
        }

        if (Files.exists(archivo)) {
            System.out.println("El archivo existe");
        } else {
            System.err.println("El archivo no existe");
        }

        List<String> lineas = List.of();

        try {
            lineas = Files.readAllLines(archivo, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }

        for (String linea : lineas) {
            System.out.println(linea);
        }

        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(carpeta)) {
            for (Path elemento : elementos) {
                System.out.println("Nombre: " + elemento.getFileName());
                try {
                    System.out.println("Tamaño: " + Files.size(elemento) + " bytes");
                    if (Files.isRegularFile(elemento)) {
                        System.out.println("Tipo: Fichero");
                    } else {
                        System.out.println("Tipo: Carpeta");
                    }
                } catch (IOException e) {
                    System.err.println("Error al consultar el elemento");
                }
            }

        } catch (IOException e) {
            System.err.println("Error al listar la carpeta");
        }

        Path copia = carpeta.resolve("copia.txt");

        try {
            Files.copy(archivo, copia);
            System.out.println("La copia se ha creado");
        } catch (IOException e) {
            System.err.println("Error al copiar el archivo");
        }

        try {
            Files.delete(copia);
            System.out.println("La copia se ha borrado");
        } catch (IOException e) {
            System.err.println("Error al borrar la copia");
        }
    }
}