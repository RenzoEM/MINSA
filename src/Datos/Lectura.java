
package Datos;

import Entidades.Dni;
import Entidades.Dosis;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lectura {
    public  Dni leerUnDato( int numeroDocumentoBuscado) {
        Dni dni = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dni.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    int numeroDocumento = Integer.parseInt(datos[0].trim());
                    if (numeroDocumento == numeroDocumentoBuscado) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechaNacimiento = sdf.parse(datos[1].trim());
                        Date emisionDni = sdf.parse(datos[2].trim());
                        String nombre = datos[3].trim();
                        dni = new Dni(numeroDocumento, fechaNacimiento, emisionDni, nombre);
                        break; // Detener la búsqueda una vez que se encuentre el DNI
                    }
                } else {
                    System.err.println("El archivo no tiene el formato esperado.");
                }
            }
            reader.close();
        } catch (IOException | ParseException e) {
            System.err.println("Error al leer el archivo.");
            e.printStackTrace();
        }
        return dni;
    }
    public Dosis leerNumeroDosis(int numeroDocumentoBuscado) {
        Dosis dosis = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dosis.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    int numeroDocumento = Integer.parseInt(datos[0].trim());
                    if (numeroDocumento == numeroDocumentoBuscado) {
                        int numeroDosis = Integer.parseInt(datos[1].trim());
                        dosis = new Dosis(numeroDocumento, numeroDosis);
                        break; // Detener la búsqueda una vez que se encuentre el DNI
                    }
                } else {
                    System.err.println("El archivo no tiene el formato esperado.");
                }
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo.");
            e.printStackTrace();
        }
        return dosis;
    }
}
