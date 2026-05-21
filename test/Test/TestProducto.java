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
        //t.update();
        //t.updateStock();
        //t.searchById();
        //t.listar();
        t.insertar();
        //t.delete();
    }

    public static void listar() {

        List<Producto> lista = dao.lista();
        if (lista != null && !lista.isEmpty()) {
            System.out.println("ID\tNombre\tStock");
            for (Producto p : lista) {
                System.out.println(p.getId_producto() + "\t"
                        + p.getNombre() + "\t$"
                        + p.getPrecio() + "\t"
                        + p.getStock());
            }
        } else {
            System.out.println("no hay data)");
        }

    }

    public static void insertar() {

        Producto p = new Producto();

        p.setNombre("Fresas");
        p.setDescripcion("Grandes");
        p.setPrecio(5);
        p.setStock(15);
        p.setImagen("/resouerce/img/fresas.jpg");

        boolean result = dao.insertar(p);

        if (result) {
            System.out.println("Datos correctos");
        } else {
            System.out.println("Datos incorrectos");
        }

    }

    public static void update() {

        Producto p = new Producto();

        p.setNombre("Camote");
        p.setDescripcion("Naranja");
        p.setPrecio(5);
        p.setStock(20);
        p.setImagen("/resouerce/img/camote.jpg");
        p.setId_producto(2);
        boolean result = dao.update(p);

        if (result) {
            System.out.println("Datos correctos");
        } else {
            System.out.println("Datos incorrectos");
        }

    }

    public static void updateStock() {

        Producto p = new Producto();

        boolean result = dao.updateStock(1, 30);

        if (result) {
            System.out.println("Datos correctos");
        } else {
            System.out.println("Datos incorrectos");
        }
    }

    public static void searchById() {

        Producto pr = dao.searchById(3);

            if (pr !=null) {
            System.out.println("id" + pr.getId_producto());
            System.out.println("nombre" + pr.getNombre());
            System.out.println("descripcion" + pr.getDescripcion());
            System.out.println("stock" + pr.getStock());
            System.out.println("precio" + pr.getPrecio());
                
            }else{
            System.out.println("No hay datos");
           
    }
            
  }
    
    public static void delete(){
    
    boolean result=dao.delete(3);

            if (result) {
            System.out.println("sistema eliminado");    
            }else{
            System.out.println("No se pudo eliminar");
    
            }
    }
}
