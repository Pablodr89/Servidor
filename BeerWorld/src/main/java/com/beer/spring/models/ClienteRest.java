package com.beer.spring.models;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

public class ClienteRest {
	Client cliente;

	public ClienteRest() {
		this.cliente = ClientBuilder.newClient();
	}

	public List<Delivery> connectApi(String id) {
		List<Delivery> lista = new ArrayList<Delivery>();
		Delivery delivery = new Delivery();

		try {
			String resultado = this.cliente.target("http://localhost:9875/api/delivery/" + id)
					.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(String.class);
			//Parsear el json y meterlo en una lista y esa lista retornarla para mandarla a la vista en un objeto maw
			JSONArray arregloJson = new JSONArray(resultado);
			/* Itera el arregloJSon y va cogiendo cada dato para meterlo en un objeto delivery y a su vez en la lista para 
			mandarlo al controlador */
			for(int i = 0; i < arregloJson.length(); i++) {
				JSONObject objetoJson = arregloJson.getJSONObject(i);
				int venta = objetoJson.getInt("id_venta");
				String usuario = String.valueOf(objetoJson.getInt("usuarios_id"));
				int producto = objetoJson.getInt("productos_id");
				double total = objetoJson.getDouble("total");
				String nombre = objetoJson.getString("nombre");
				delivery = new Delivery(venta,usuario,producto,total,nombre);
				lista.add(delivery);
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			return lista;
		}

	}

