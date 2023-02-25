package com.beer.spring.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
    	Product product = new Product();
        
    	product.setId(rs.getInt("id"));
    	product.setNombre(rs.getString("nombre"));
    	product.setPrecio(rs.getDouble("precio"));
    	product.setImagen(rs.getString("imagen"));
        
        return product;
    }
}



