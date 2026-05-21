/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Dao.ProductoDaoImpl;
import Interface.IProducto;
import Model.Producto;
import java.util.List;

/**
 *
 * @author HP
 */
public class TestProducto {

    public static IProducto dao = new ProductoDaoImpl();
    
    public static void main(String[] args) {
       TestProducto t = new TestProducto();
       t.listar();
    }
    
    public static void listar(){
        
        List<Producto> lista = dao.lista();
        if (lista !=null && !lista.isEmpty()) {
            System.out.println("ID\tNombre\tStock");
            for (Producto p : lista) {
                System.out.println(p.getId_producto() +"\t" 
                        + p.getNombre() + "\t$" 
                        + p.getPrecio() + "\t"
                        + p.getStock());
            }
        } else {
            System.out.println("no hay data)");
        }
        
    }
}
