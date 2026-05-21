/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;


import Dao.PersonaDaoImpl;
import Dao.UsuarioDaoImpl;
import Interface.IPersona;
import Interface.IUsuario;
import Model.Persona;
import Model.Usuario;

/**
 *
 * @author HP
 */
public class TestPersona {

    IPersona dao = new PersonaDaoImpl();
    IUsuario Udao = new UsuarioDaoImpl();
    
    public static void main(String[] args) {
        TestPersona t = new TestPersona();
        //t.crear_ususario();
        t.validate();
    }
    
    public void crear_ususario() {
        
        Persona p= new Persona();
        p.setNombre("Fabiola Isabel");
        p.setEmail("fabiola@gmail");
        p.setDireccion("Jr.Manzana");
        p.setTelefono("12345678");
        
        Usuario u = new Usuario();
        u.setPassword("admin123");
        int result = dao.insertar(p, u);
        
        if (result>0) {
            System.out.println("Usuario" + p.getEmail());
            System.out.println("rol" + u.getRol());
        } else {
            System.err.println("No se realizo el registro.");
        }
          
    }
    
    public void validate(){
        
        Usuario u = Udao.validate("fabiola@gamil.com", "admin234");
        if (u !=null && u.getPersona() !=null) {
            
            System.out.println("Bienvenido" +u.getPersona().getNombre());
            System.err.println("rol" +u.getRol());
            
            
        }else{
            System.out.println("credenciales incorrectas");
        }
        
    }



}
