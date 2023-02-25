package com.BeerWorld.springRest.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BeerWorld.springRest.models.Usuarios;
import com.BeerWorld.springRest.repository.UserRepository;
import com.BeerWorld.springRest.services.DeliveryServiceImpl;
import com.BeerWorld.springRest.models.Pedidos;
import com.BeerWorld.springRest.repository.DeliveryRepository;
import com.BeerWorld.springRest.models.Productos;
import com.BeerWorld.springRest.repository.ProductRepository;



@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DeliveryRepository deliveryRepository;
	@Autowired
	DeliveryServiceImpl deliveryService;
	@Autowired
	ProductRepository productRepository;
		
		/**
		 * Retorna todos los usuarios.
		 * 
		 * @return List<User>
		 */
		@GetMapping("/users")
		public List<Usuarios> allUser() {
		
			return userRepository.findAll();	
		}
		
		/**
		 * Búsqueda por atributos (ID)
		 * 
		 * @param user
		 * @return User
		 */
		@GetMapping("/user/{id}")
		public ResponseEntity<Usuarios> searchUserById(@PathVariable Long id) {
			
			Usuarios user = userRepository.findById(id).orElse(null);
			
			return ResponseEntity.ok(user);
		}
		
		/**
		 * Retorna todos los pedidos.
		 * 
		 * @return List<Delivery>
		 */
		@GetMapping("/deliverys")
		public List<Pedidos> allDeliverys() {
		
			return deliveryRepository.findAll();	
		}
		
		/**
		 * Búsqueda por atributos (ID)
		 * 
		 * @param delivery
		 * @return Delivery
		 */
		@GetMapping("/delivery/{usuarios_id}")
		public List<Pedidos> searchDeliveryById(@PathVariable Long usuarios_id) {
			
			return deliveryService.getDelivery(usuarios_id);
		}
		
		/**
		 * Retorna todos los productos.
		 * 
		 * @return List<Product>
		 */
		@GetMapping("/products")
		public List<Productos> allProducts() {
		
			return productRepository.findAll();	
		}
		
		/**
		 * Búsqueda por atributos (ID)
		 * 
		 * @param product
		 * @return Product
		 */
		@GetMapping("/product/{id}")
		public ResponseEntity<Productos> searchProductById(@PathVariable Long id) {
			
			Productos product = productRepository.findById(id).orElse(null);
			
			return ResponseEntity.ok(product);
		}
}
