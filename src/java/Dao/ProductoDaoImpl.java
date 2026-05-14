/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.IProducto;
import Model.Producto;
import Util.ConexionSingleton;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ProductoDaoImpl implements IProducto{

    private Connection cn;
    
    @Override
    public List<Producto> lista() {

        List<Producto> lista=null;
        Producto pr;
        PreparedStatement st;
        ResultSet rs;
        String query = null;
        
        try {
            
            query="SELECT idi_producto, nombre, descripcion, precio,"
                  + "stock FROM productos;";
                    lista = new ArrayList<>();
                    cn=ConexionSingleton.getConnection();
                    st=cn.prepareStatement(query);
                    rs= st.executeQuery();
                    while (rs.next()) {                
                pr = new Producto();
                pr.setId_producto(rs.getInt("id_prodcuto"));
                pr.setNombre(rs.getString("nombre"));
                pr.setDescripcion(rs.getString("descripcion"));
                pr.setPrecio(rs.getDouble("precio"));
                pr.setStock(rs.getInt("stock"));
                lista.add(pr);
            }
                    
        } catch (Exception e) {
            System.out.println("Error al listar" + e.getMessage());
            try {
                cn.rollback();
                
            } catch (Exception ex) {
                System.out.println("Error de rollback" + ex.getMessage());
            }
        } finally {
            if (cn!=null) {
                try {
                    
                } catch (Exception ex) {
                }
                
            }
        }
        
       return lista;
    }

    @Override
    public boolean insertar(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto searchById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateStock(int id, int stock) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
