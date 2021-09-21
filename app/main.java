import java.util.Scanner;

import clases.Usuario;
import clases.Objetivo;
import clases.Hash;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario login = null;
        System.out.println("bienvenido");
        int seleccion;
        do {
            System.out.println("Presione 1 para registrarse");
            System.out.println("Presione 2 para iniciar sesión");
            System.out.println("Presione 3 para Eliminar usuario");
            System.out.println("Presione 4 para salir");
            seleccion = reader.nextInt();
            reader.nextLine();
            switch (seleccion) {
                case 1: 
                    usuarios = Usuario.add_user(usuarios);
                    break;
                case 2:
                    login = Usuario.log_in(usuarios);
                    if (login != null) {
                        int iniSes;
                        do {
                            System.out.println("Presione 1 para crear objetivo");
                            System.out.println("Presione 2 para consultar objetivo");
                            System.out.println("Presione 3 para eliminar objetivo");
                            System.out.println("Presione 4 para cerrar sesion");
                            iniSes = reader.nextInt();
                            reader.nextLine();
                            switch (iniSes) {
                                case 1: 
                                    Objetivo.crearObjetivo(login);
                                    break;
                                case 2: 
                                    Objetivo.consultarObjetivo(login);
                                    break;
                                case 3:
                                    break;
                            }
                        } while (iniSes != 4);
                    } else {
                        System.out.println("No se pudo iniciar sesion");
                    }
                    break;
                case 3:
                         Usuario.delete_User(usuarios);
                        
                break; 
            }
        } while (seleccion != 4);

    }
}
