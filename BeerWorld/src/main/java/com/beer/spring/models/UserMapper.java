package com.beer.spring.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
        User user = new User();
        
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setAdmin(rs.getInt("admin"));
        user.setId(rs.getString("id"));
        user.setNombre(rs.getString("nombre"));
        user.setApellidos(rs.getString("apellidos"));
        user.setNacimiento(rs.getString("nacimiento"));
        user.setTelefono(rs.getString("telefono"));
        user.setDni(rs.getString("dni"));
        user.setDireccion(rs.getString("direccion"));
        user.setCp(rs.getString("CP"));
        user.setCiudad(rs.getString("ciudad"));
	    user.setPrivado(rs.getString("privado"));

        return user;
    }
}
