package clases;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private String nombre;
    private String contra;
    private ArrayList<Objetivo> lista_objetivos;

    // contructor
    public Usuario(String nombre, String contra) {
        this.nombre = nombre;
        this.contra = contra;
        this.lista_objetivos = new ArrayList<>();
    }

    /*
     * metodos----  
                    -> Agregar USUARIO
                    -> Eliminar USUARIO ->
                    -> Iniciar de sesion
     */

    public String get_name() {
        return this.nombre;
    }

    public String get_pass() {
        return this.contra;
    }

    public ArrayList<Objetivo> get_hashlist() {
        return this.lista_objetivos;
    }

    public static Usuario log_in (ArrayList<Usuario> usuarios){
            Usuario login = null;
            Scanner reader = new Scanner(System.in);
            System.out.println("---Inicio sesión---");
            System.out.println("Ingrese su usuario");
            String user_ini = reader.nextLine();
            System.out.println("Ingrese su contraseña");
            String passini = reader.nextLine();
            for (Usuario i : usuarios) {
                if (i.get_name().equals(user_ini)) {
                    if (i.get_pass().equals(passini)) {
                        login = i;
                        break;
                    }
                }
            }
            if (login != null) {
                System.out.println("Iniciaste sesión");
                
            } else {
                System.out.println("No se pudo iniciar sesion");
            }     
    
        return login;
    }

    public static ArrayList<Usuario> add_user(ArrayList<Usuario> usuarios){
        Scanner reader = new Scanner(System.in);

        System.out.println("---Registro---");

        System.out.println("Ingrese Su usuario: ");
        String user = reader.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String pass = reader.nextLine();
        Boolean existe = false;      
        for (Usuario i : usuarios) {
            if (i.get_name().equals(user)) {
                System.out.println("El usuario ya existe");
                existe = true;
                break;
            }
        }
        if (existe == false) {
            Usuario nuevo = new Usuario(user, pass);
            usuarios.add(nuevo);
        }
        return usuarios;
    }

    public  Boolean find_user(String user, String pass) {
        if((pass.equals(this.contra)) && (user.equals(this.nombre))){ 
            return true;
        } else {
            return false;
        }
    }

    

    public static void delete_User(ArrayList<Usuario> usuarios){
        int id;
        Scanner reader = new Scanner(System.in);
        System.out.println("Digite el Nombre Usuario que desea eliminar: ");
        String eliminado =  reader.nextLine();
        boolean existe = false;
        for (Usuario i : usuarios){
            if (i.get_name().equals(eliminado)) {
                id = usuarios.indexOf(i);
                usuarios.remove(id);
                System.out.println("El usuario -"+ eliminado +"- Ya fue eliminado");
                System.out.println("El ID eliminado: "+id);
                existe = true;
                break;
            }
        }
        if(!existe){
            System.out.println("No se encontro el Nombre de usuario: "+ eliminado);
        }
    }

}
