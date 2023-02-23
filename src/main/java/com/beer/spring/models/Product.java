package com.beer.spring.models;

import java.util.ArrayList;

/**
 * Clase Producto
 * 
 * @author Pablo Dominguez
 *
 */
public class Product {

	protected int id;
	protected String nombre;
	protected double precio;
	protected String imagen;
	
	public Product(String nombre, double precio, String imagen) {
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
	}
	
	public Product() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Product [nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen + "]";
	}
	/**
	 * 
	 * @return mensajes de errores para validar producto en el carrito
	 */
	public ArrayList<String> validateProduct() {
		
		ArrayList<String> mensaje = new ArrayList<String>();
		boolean error = true;
		
		if(this.nombre == null || this.nombre.equals("")) {
			mensaje.add("No ha añadido ningún producto");
			error = false;
		}
		
		return mensaje;
	}
}
