package com.BeerWorld.springRest.models;

import java.sql.Date;

/**
 * Clase Persona
 * 
 * @author Pablo Dominguez
 *
 */
public class Person {

	protected Long id;
	protected String nombre;
	protected String apellidos;
	protected Date nacimiento;
	protected String telefono;
	protected String dni;
	protected String direccion;
	protected String cp;
	protected String ciudad;
	protected String privado;
	
	public Person(String nombre, String apellidos, Date nacimiento, String telefono, String dni, String direccion,
			String cp, String ciudad, String privado) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacimiento = nacimiento;
		this.telefono = telefono;
		this.dni = dni;
		this.direccion = direccion;
		this.cp = cp;
		this.ciudad = ciudad;
		this.privado = privado;
}
	
	public Person() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getPrivado() {
		return privado;
	}

	public void setPrivado(String privado) {
		this.privado = privado;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", fNacimiento=" + nacimiento + ", telefono="
				+ telefono + ", dni=" + dni + ", direccion=" + direccion + ", cp=" + cp + ", ciudad=" + ciudad + "]";
	}
}
