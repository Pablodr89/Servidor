package com.beer.spring.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class PersonMapper implements RowMapper<Person> {

	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			
	    Person person = new Person();
	       
	   	person.setId(rs.getString("id"));
	   	person.setNombre(rs.getString("nombre"));
	   	person.setApellidos(rs.getString("apellidos"));
	    person.setNacimiento(rs.getString("nacimiento"));
	    person.setTelefono(rs.getString("telefono"));
	    person.setDni(rs.getString("dni"));
	    person.setDireccion(rs.getString("direccion"));
	    person.setCp(rs.getString("CP"));
	    person.setCiudad(rs.getString("ciudad"));
	    person.setPrivado(rs.getString("privado"));
	        
        return person;
    }
}
