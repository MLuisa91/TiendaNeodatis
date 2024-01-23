package vista;

import java.util.ArrayList;

import modelo.Cliente;
public class Main {

    public static ArrayList<Cliente> usuarios;
   
    public static void main(String[] args) {
        
        usuarios = new ArrayList<>();
        //Cliente nuevo = new Cliente("admin", "admin");
       // usuarios.add(nuevo);
        
        Login log = new Login();
        log.setVisible(true);
        
        
        
    }
    
}
