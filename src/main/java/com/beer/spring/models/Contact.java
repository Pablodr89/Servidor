package com.beer.spring.models;

import java.util.ArrayList;

/**
 * Clase contacto
 * 
 * @author Pablo Dominguez
 *
 */
public class Contact extends Person{

	protected String email;
	protected String mensaje;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * 
	 * @return mensajes de error para validar el formulario de contacto
	 */
	public ArrayList<String> validateContact() {
		
		ArrayList<String> mensaje = new ArrayList<String>();
		boolean error = true;
		
		if(this.nombre == null || this.nombre.equals("")) {
			mensaje.add("El nombre es obligatorio");
			error = false;
		}
		
		if(this.email == null || this.email.equals("")) {
			mensaje.add("El email es obligatorio");
			error = false;
		}
		
		if(this.telefono == null || this.telefono.equals("")) {
			mensaje.add("El telefono es obligatorio");
			error = false;
		} else if(this.telefono.length() < 9 || this.telefono.length() > 12) {
			mensaje.add("El telefono debe tener entre 9 y 12 digitos");
			error = false;
		}
		
		if(this.mensaje == null || this.mensaje.equals("")) {
			mensaje.add("El mensaje es obligatorio");
			error = false;
		}
		
		if(error) {
			mensaje.add("Mensaje enviado con éxito");
		}
		
		return mensaje;
	}
}
