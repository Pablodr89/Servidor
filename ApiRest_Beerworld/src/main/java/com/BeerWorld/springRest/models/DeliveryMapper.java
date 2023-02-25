package com.BeerWorld.springRest.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeliveryMapper implements RowMapper<Pedidos> {

    public Pedidos mapRow(ResultSet rs, int rowNum) throws SQLException {
		
    	Pedidos delivery = new Pedidos();
        
    	delivery.setId_venta(rs.getLong("id_venta"));
    	delivery.setUsuarios_id(rs.getLong("usuarios_id"));
    	delivery.setProductos_id(rs.getInt("productos_id"));
    	delivery.setNombre(rs.getString("nombre"));
    	delivery.setTotal(rs.getDouble("total"));
        
        return delivery;
    }

	
}
