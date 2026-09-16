import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class dades {

    public static void main(String[] args) {

        // Escribir 3 líneas en el fichero
        try {
            FileWriter fw = new FileWriter("dades.txt");
            fw.write("Línea 1: Hola mundo\n");
            fw.write("Línea 2: Aprendiendo Java\n");
            fw.write("Línea 3: Ficheros de texto\n");
            fw.close();
            System.out.println("Fichero escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero.");
        }

        // Leer el fichero y mostrarlo por pantalla
        try {
            File fichero = new File("dades.txt");
            Scanner sc = new Scanner(fichero);

            System.out.println("Contenido del fichero:");
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                System.out.println(linea);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero.");
        }
    }
}