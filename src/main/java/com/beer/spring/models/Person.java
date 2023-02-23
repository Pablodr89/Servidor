package com.beer.spring.models;

import java.util.ArrayList;

/**
 * Clase Persona
 * 
 * @author Pablo Dominguez
 *
 */
public class Person {

	protected String id;
	protected String nombre;
	protected String apellidos;
	protected String nacimiento;
	protected String telefono;
	protected String dni;
	protected String direccion;
	protected String cp;
	protected String ciudad;
	protected String privado;
	
	public Person(String nombre, String apellidos, String nacimiento, String telefono, String dni, String direccion,
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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
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
	/**
	 * 
	 * @return mensaje de error para validacion de formularios
	 */
	public ArrayList<String> validatePerson() {
		
		ArrayList<String> mensaje = new ArrayList<String>();
		boolean error = true;
		
		if(this.nombre == null || this.nombre.equals("")) {
			mensaje.add("El nombre es obligatorio");
			error = false;
		}
		
		if(this.apellidos == null || this.apellidos.equals("")) {
			mensaje.add("Los apellidos son obligatorios");
			error = false;
		}
		
		if(this.nacimiento == null || this.nacimiento.equals("")) {
			mensaje.add("La fecha de nacimiento es obligatoria");
			error = false;
		}
		
		if(this.telefono == null || this.telefono.equals("")) {
			mensaje.add("El telefono es obligatorio");
			error = false;
		} else if(this.telefono.length() < 9 || this.telefono.length() > 12) {
			mensaje.add("El telefono debe tener entre 9 y 12 digitos");
			error = false;
		}
		
		if(this.dni == null || this.dni.equals("")) {
			mensaje.add("El DNI es obligatorio");
			error = false;
		} else if(this.dni.length() < 9) {
			mensaje.add("El DNI debe tener 9 caracteres");
			error = false;
		}
		
		if(this.direccion == null || this.direccion.equals("")) {
			mensaje.add("La dirección es obligatoria");
			error = false;
		}
		
		if(this.cp == null || this.cp.equals("")) {
			mensaje.add("El codigo postal es obligatorio");
			error = false;
		} 
		
		if(this.ciudad == null || this.ciudad.equals("")) {
			mensaje.add("La ciudad es obligatoria");
			error = false;
		}
		
		if(this.privado == null) {
			mensaje.add("Debe aceptar los terminos de privacidad");
			error = false;
		}
		
		return mensaje;
	}
}
