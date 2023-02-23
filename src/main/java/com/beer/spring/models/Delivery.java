package com.beer.spring.models;

/**
 * Clase pedido
 * 
 * @author Pablo Dominguez
 *
 */
public class Delivery {
	protected int id_venta;
	protected String usuarios_id;
	protected int producto_id;
	protected String nombre;
	protected double total;
	
	
	
	public Delivery(int id_venta, String usuarios_id, int producto_id, double total, String nombre) {
		this.id_venta = id_venta;
		this.usuarios_id = usuarios_id;
		this.producto_id = producto_id;
		this.total = total;
		this.nombre = nombre;
	}

	public Delivery() {
		
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public String getUsuarios_id() {
		return usuarios_id;
	}

	public void setUsuarios_id(String usuarios_id) {
		this.usuarios_id = usuarios_id;
	}

	public int getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
