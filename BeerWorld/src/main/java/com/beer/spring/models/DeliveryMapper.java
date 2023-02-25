package com.beer.spring.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeliveryMapper implements RowMapper<Delivery> {

    public Delivery mapRow(ResultSet rs, int rowNum) throws SQLException {
		
    	Delivery delivery = new Delivery();
        
    	delivery.setId_venta(rs.getInt("id_venta"));
    	delivery.setUsuarios_id(rs.getString("usuarios_id"));
    	delivery.setProducto_id(rs.getInt("productos_id"));
    	delivery.setNombre(rs.getString("nombre"));
    	delivery.setTotal(rs.getDouble("total"));
        
        return delivery;
    }

	
}
