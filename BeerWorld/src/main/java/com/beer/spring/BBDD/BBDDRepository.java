package com.beer.spring.BBDD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.beer.spring.models.Delivery;
import com.beer.spring.models.DeliveryMapper;
import com.beer.spring.models.Product;
import com.beer.spring.models.ProductMapper;
import com.beer.spring.models.User;
import com.beer.spring.models.UserMapper;

/**
 * Clase Repository
 * 
 * @author Pablo Dominguez
 *
 */

@Repository
public class BBDDRepository {

	 /** Attributes */
    @Autowired
    protected JdbcTemplate jt;

    /**
     * 
     * @param email
     * @param pass
     * @return lista de usuarios coincidentes con el email y el password
     */
    public List<User> getUserByUsernameAndPass(String email, String pass) {
        
        String query = "SELECT * FROM Usuarios WHERE email = '" + email + "' AND password = '" + pass +"'";
        
        return jt.query(query, new UserMapper());
    }
    /**
     * 
     * @return todos los usuarios
     */
    public List<User> getAllUsers() {
        
        String query = "SELECT * FROM Usuarios";
        
        return jt.query(query, new UserMapper());
    }
    /**
     * 
     * @param email
     * @return usuario coincidente con su email
     */
    public List<User> getUser(Object email) {
    	
    	String query = "SELECT * FROM Usuarios WHERE email = '" + email + "'";
    	
    	return jt.query(query, new UserMapper());
    }
    /**
     * 
     * @return todos los productos
     */
    public List<Product> getAllProducts() {
        
        String query = "SELECT * FROM Productos";
        
        return jt.query(query, new ProductMapper());
    }
    /**
     * 
     * @param id producto
     * @return producto coincidente con su id
     */
    public List<Product> getProductsById(String id) {
        
        String query = "SELECT * FROM Productos WHERE id = " + id;
        
        return jt.query(query, new ProductMapper());
    }
    /**
     * 
     * @param nombre producto
     * @return producto coincidente con su nombre
     */
    public List<Product> getProductsByName(String name) {
        
        String query = "SELECT * FROM Productos WHERE nombre = '" + name + "'";
        
        return jt.query(query, new ProductMapper());
    }
    /**
     * 
     * @param id usuario
     * @return los pedidos coincidentes con el id usuario
     */
    public List<Delivery> getDelivery(String id) {
        
        String query = "SELECT pe.id_venta, pe.usuarios_id, pe.productos_id, pr.nombre, pe.total FROM Pedidos pe "
        		+ " INNER JOIN Productos pr ON pr.id = pe.productos_id"
        		+ " WHERE usuarios_id = " + id;
        
        return jt.query(query, new DeliveryMapper());
    }
    /**
     * 
     * @param userId pedido
     * @return el pedido coincidente con el id pedido
     */
    public List<Delivery> getDeliveryById(String userId) {
        
        String query = "SELECT * FROM Pedidos WHERE usuarios_id= " + userId;
        
        return jt.query(query, new DeliveryMapper());
    }
    /**
     * 
     * @param userId
     * @param productos_id
     * @param price
     * @param id_venta
     * @param nombre
     * 
     * Insertar pedido en la BBDD
     */
    public void insertDelivery(String userId, int productos_id, double price, int id_venta, String nombre) {
    	 
    	String query = "INSERT Pedidos(id_venta, usuarios_id, productos_id, total, nombre)"
    			+ "VALUES(" + id_venta + ", " + userId + ", " + productos_id + ", " + price + ", '" + nombre + "')";
    	
    	jt.update(query);
    }

}
