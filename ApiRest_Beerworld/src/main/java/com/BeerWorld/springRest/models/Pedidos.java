package com.BeerWorld.springRest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Clase pedido
 * 
 * @author Pablo Dominguez
 *
 */

@Entity
public class Pedidos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	protected long usuarios_id;
	protected Long id_venta;
	protected int productos_id;
	protected double total;
	protected String nombre;
	
	
	
	public Pedidos(Long id_venta, long usuarios_id, int productos_id, double total, String nombre) {
		this.id_venta = id_venta;
		this.usuarios_id = usuarios_id;
		this.productos_id = productos_id;
		this.total = total;
		this.nombre = nombre;
	}

	public Pedidos() {
		
	}

	public Long getId_venta() {
		return id_venta;
	}

	public void setId_venta(Long id_venta) {
		this.id_venta = id_venta;
	}

	public long getUsuarios_id() {
		return usuarios_id;
	}

	public void setUsuarios_id(long usuarios_id) {
		this.usuarios_id = usuarios_id;
	}

	public int getProductos_id() {
		return productos_id;
	}

	public void setProductos_id(int productos_id) {
		this.productos_id = productos_id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
