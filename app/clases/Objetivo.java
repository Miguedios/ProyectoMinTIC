package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Objetivo {
    private String nombre, descripcion;
    private int horasTotales, horasRestantes, horasDedicadas;
    private ArrayList<Integer> hash;

    public Objetivo(String nombre, String descripcion, int horasTotales, ArrayList<Integer> hash) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horasTotales = horasTotales;
        this.horasRestantes = horasTotales;
        this.horasDedicadas = 0;
        this.hash = hash;
    }

    public void recalcularHorasRestantes() {
        this.horasRestantes = horasTotales - horasDedicadas;
    }

    public Boolean encontrarObjetivo(String nombre) {
        if (this.nombre == nombre){
            return true;
        } else {
            return false;
        }
    }

    public String get_name() {
        return this.nombre;
    }

    public String get_desc() {
        return this.descripcion;
    }

    public int get_horasTot() {
        return this.horasTotales;
    }

    public int get_horasRest() {
        return this.horasRestantes;
    }

    public int get_horasDed() {
        return this.horasDedicadas;
    }

    public ArrayList<Integer> get_hashlist() {
        return this.hash;
    }

    public static void crearObjetivo(Usuario login) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Crear objetivo");
        System.out.println("Ingrese el nombre del objetivo");
        String nom = reader.nextLine();
        System.out.println("Ingrese la descripcion del objetivo");
        String desc = reader.nextLine();
        System.out.println("Ingrese las horas a dedicar");
        int hora = reader.nextInt();
        reader.nextLine();
        System.out.println("Ingrese el horario en este formato: dia,hora,dia,hora");
        String formato = reader.nextLine();
        
        String[] dt = formato.split(",");
        ArrayList<Integer> listaHash = new ArrayList<>();
        
        for (int i = 0; i < dt.length; i+=2) {
            int dia = Hash.calculateDay(dt[i]);
            int horaDia = Integer.parseInt(dt[i+1]);
            int hash = Hash.calculateHash(dia, horaDia);
            listaHash.add(hash);
        }
        Objetivo nuevoObj = new Objetivo(nom, desc, hora, listaHash);
        login.get_hashlist().add(nuevoObj);
    }

    public void consultarObjetivo (Usuario login) {
        System.out.println("Consultar objetivos");
        if (login.get_hashlist().isEmpty()) {
            System.out.println("No hay objetivos");
        } else {
            for (int i = 0; i < login.get_hashlist().size(); i++) {
                System.out.println(login.get_hashlist().get(i).get_name());
                System.out.println(login.get_hashlist().get(i).get_desc());
                System.out.println(login.get_hashlist().get(i).get_horasTot());
                System.out.println(login.get_hashlist().get(i).get_horasDed());
                System.out.println(login.get_hashlist().get(i).get_horasRest());
                System.out.println(login.get_hashlist().get(i).get_hashlist());
            }
        }
    }




}
