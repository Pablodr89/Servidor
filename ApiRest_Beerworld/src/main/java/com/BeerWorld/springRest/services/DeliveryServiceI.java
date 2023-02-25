package com.BeerWorld.springRest.services;

import java.util.List;

import com.BeerWorld.springRest.models.Pedidos;


public interface DeliveryServiceI {

	public List<Pedidos> getDelivery(Long id);
}
