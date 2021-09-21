package clases;
import java.util.Calendar;


public class Hash {
    public static int calculateHash(int dia, int hora) {
        return (dia * 24 + hora);
    }

    public static int calculateDay (String dia) {
        if (dia.equals("Domingo") || dia.equals("domingo")) {
            return 0;
        } else if (dia.equals("Lunes") || dia.equals("lunes")) {
            return 1;
        }  else if (dia.equals("Martes") || dia.equals("martes")) {
            return 2;
        }else if (dia.equals("Miercoles") || dia.equals("miercoles")) {
            return 3;
        }else if (dia.equals("Jueves") || dia.equals("jueves")) {
            return 4;
        }else if (dia.equals("Viernes") || dia.equals("viernes")) {
            return 5;
        } else if (dia.equals("Sabado") || dia.equals("sabado")) {
            return 6;
        } else {
            return -1;
        }
    }
}
