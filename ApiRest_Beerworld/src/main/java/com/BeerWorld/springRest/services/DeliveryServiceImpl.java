package com.BeerWorld.springRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.BeerWorld.springRest.repository.DeliveryRepository;
import com.BeerWorld.springRest.models.DeliveryMapper;
import com.BeerWorld.springRest.models.Pedidos;


@Service
public class DeliveryServiceImpl implements DeliveryServiceI {
	
	@Autowired
	DeliveryRepository clienterepositorio;
	@Autowired
    protected JdbcTemplate jt;

	@Override
	public List<Pedidos> getDelivery(Long id) {
        
        String query = "SELECT pe.id_venta, pe.usuarios_id, pe.productos_id, pr.nombre, pe.total FROM Pedidos pe "
        		+ " INNER JOIN Productos pr ON pr.id = pe.productos_id"
        		+ " WHERE usuarios_id = " + id;
        
        return jt.query(query, new DeliveryMapper());
	}
}