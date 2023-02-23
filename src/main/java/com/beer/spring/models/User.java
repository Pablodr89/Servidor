package com.beer.spring.models;

import java.util.ArrayList;

import com.beer.spring.BBDD.BBDDRepository;
/**
 * Clase Usuario
 * 
 * @author Pablo Dominguez
 *
 */
public class User extends Person{
	
	protected String id;
	protected String email;
	protected String password;
	protected int admin;

	public User(String id, String email, String password, int admin) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public User() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", admin=" + admin + "]";
	}
	/**
	 * 
	 * @param email
	 * @param password
	 * @return los mensajes de error del email o password
	 */
	public ArrayList<String> validateUser(String email, String password) {
		
		ArrayList<String> mensaje = new ArrayList<String>();
		BBDDRepository BBDD = new BBDDRepository();
		boolean error = true;
		
		if(this.email == null || this.email.equals("")) {
			mensaje.add("El email es obligatorio");
			error = false;
		}
		
		if(this.password == null || this.password.equals("")) {
			mensaje.add("La contraseña es obligatoria");
			error = false;
		}
		
		return mensaje;
	}
}
