package Negocio;

import Datos.Lectura;
import Entidades.Dni;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Logica {

    Lectura dni = new Lectura();

    /*
    public boolean validarExistencia(int numeroDocumento, String fechaNacimiento, String fechaEmision){
        if(dni.leerUnDato(numeroDocumento)==null){
            System.out.println("1111");
            return false;
        }
        if(fechaNacimiento.equals(dni.leerUnDato(numeroDocumento).getFechaNacimiento().toString())){
            System.out.println("2222");
            return false;
        }
        if(fechaEmision.equals(dni.leerUnDato(numeroDocumento).getEmisionDni().toString())){
            System.out.println("3333");
            return false;
        }
        return true;
    }
     */
 /*
    public boolean validarExistencia(int numeroDocumento, String fechaNacimiento, String fechaEmision) {
        Dni dniEncontrado = dni.leerUnDato(numeroDocumento);
        if (dniEncontrado == null) {
            System.out.println("El DNI no existe en el archivo.");
            return false;
        }

        // Validar fecha de emisión del DNI
        if (dniEncontrado.getEmisionDni().compareTo(dniEncontrado.getFechaNacimiento()) < 0
                || dniEncontrado.getEmisionDni().compareTo(dniEncontrado.getFechaNacimiento()) < 0) {
            System.out.println("La fecha de emisión del DNI es inválida.");
            return false;
        }

        // Validar si la fecha de emisión es menor a la fecha recibida como parámetro
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaEmisionDate = sdf.parse(fechaEmision);
            if (dniEncontrado.getEmisionDni().compareTo(fechaEmisionDate) > 0) {
                System.out.println("La fecha de emisión del DNI es posterior a la proporcionada.");
                return false;
            }
        } catch (ParseException e) {
            System.err.println("Error al parsear la fecha de emisión proporcionada.");
            e.printStackTrace();
            return false;
        }

        return true;
    }
     */
    public boolean validarExistencia(int numeroDocumento, String fechaNacimiento, String fechaEmision) {
        Dni dniEncontrado = dni.leerUnDato(numeroDocumento);
        if (dniEncontrado == null) {
            System.out.println("El DNI no existe en el archivo.");
            return false;
        }

        // Validar fecha de nacimiento del DNI
        if (dniEncontrado.getFechaNacimiento().compareTo(dniEncontrado.getEmisionDni()) > 0) {
            System.out.println("La fecha de nacimiento del DNI es posterior a la fecha de emisión.");
            return false;
        }

        // Validar fecha de emisión del DNI
        if (dniEncontrado.getEmisionDni().compareTo(dniEncontrado.getFechaNacimiento()) < 0) {
            System.out.println("La fecha de emisión del DNI es anterior a la fecha de nacimiento.");
            return false;
        }

        // Validar si la fecha de emisión es menor a la fecha recibida como parámetro
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaEmisionDate = sdf.parse(fechaEmision);
            if (dniEncontrado.getEmisionDni().compareTo(fechaEmisionDate) > 0) {
                System.out.println("La fecha de emisión del DNI es posterior a la proporcionada.");
                return false;
            }
        } catch (ParseException e) {
            System.err.println("Error al parsear la fecha de emisión proporcionada.");
            e.printStackTrace();
            return false;
        }

        // Validar si la fecha de nacimiento es menor a la fecha recibida como parámetro
        try {
            Date fechaNacimientoDate = sdf.parse(fechaNacimiento);
            if (dniEncontrado.getFechaNacimiento().compareTo(fechaNacimientoDate) > 0) {
                System.out.println("La fecha de nacimiento del DNI es posterior a la proporcionada.");
                return false;
            }
        } catch (ParseException e) {
            System.err.println("Error al parsear la fecha de nacimiento proporcionada.");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public String obtenerNombre(int numeroDocumento) {

        return dni.leerUnDato(numeroDocumento).getNombre();
    }

    public int obtenerNumeroDosis(int numeroDocumento) {
        return dni.leerNumeroDosis(numeroDocumento).getNumeroDosis();
    }

    public int obtenerEdad(int numeroDocumento) {
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(dni.leerUnDato(numeroDocumento).getFechaNacimiento());

        Calendar fechaActual = Calendar.getInstance();

        int años = fechaActual.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);

        // Si la fecha actual es antes que la fecha de nacimiento, resta un año
        if (fechaActual.get(Calendar.DAY_OF_YEAR) < fechaNacimientoCal.get(Calendar.DAY_OF_YEAR)) {
            años--;
        }

        return años;
    }
}
