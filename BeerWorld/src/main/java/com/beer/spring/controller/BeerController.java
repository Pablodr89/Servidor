package com.beer.spring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beer.spring.BBDD.BBDDRepository;
import com.beer.spring.models.User;
import com.beer.spring.models.ClienteRest;
import com.beer.spring.models.Contact;
import com.beer.spring.models.Delivery;
import com.beer.spring.models.Person;
import com.beer.spring.models.Product;

/**
 * Controller
 * 
 * @author Pablo Dominguez
 *
 */
//TODO si da tiempo probar a pedir los datos de usuarios y los productos a la API
@Controller
public class BeerController {
@Autowired
protected BBDDRepository BBDD;

	@RequestMapping("/index")
	public ModelAndView indexIntranet(HttpServletRequest request) {
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView loginIntranet(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		List<Product> lista = BBDD.getAllProducts();
		ModelAndView maw = new ModelAndView("tienda");
		maw.addObject("product", lista);

		//Comprueba si se ha iniciado sesion, devuelve la vista de la tienda si esta logueado, si no le devuelve al login
        if (session.getAttribute("login") != null) {
        	
        	return maw;
        }
        	
		return new ModelAndView("login");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/tienda")
	public ModelAndView tiendaIntranet(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		User user = new User();
		ModelAndView maw = new ModelAndView("login");
		ModelAndView maw1 = new ModelAndView("tienda");
		ArrayList<String> mensaje = new ArrayList<String>();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//Lista para coger todos los productos de la BBDD y printarlos en la tienda
		List<Product> lista = BBDD.getAllProducts();
		
		//Lista para buscar el usuario por email y password
		List<User> login = BBDD.getUserByUsernameAndPass(email, password);
		
		//Mete los productos en la sesion y los pasa al carrito para imprimirlos
		String id = request.getParameter("id");
		List<Product> products = new ArrayList<Product>();
		Object product = session.getAttribute("compra");
		
		/* Comprueba si la sesion de compra tiene productos, si no es nula, iguala ese producto a la lista de productos y 
		  añade el nuevo producto añadido */
		if(session.getAttribute("compra") != null) {
			
			products.addAll((Collection<? extends Product>) product);
			
		} else {
			
			product = null;
		}
		
		//Si añade un nuevo producto, coge su id, busca el producto por id y lo añade a la lista
		if(id != null) {
			products.add(BBDD.getProductsById(id).get(0));
			//Le pasa la lista de productos añadidos a la sesion
			session.setAttribute("compra", products);
		}
				
		/* Comprobar que el usuario existe y que los campos estén rellenos */
		
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		maw1.addObject("product", lista);
		maw.addObject("user", user);
		
		//Comprueba que los campos de mail y contraseña esten rellenos, si no manda mensaje de error
		if(user.getEmail() != null) {
			
			mensaje = user.validateUser(email, password);
			
		} 
		
		//Comprueba que el usuario existe en la base de datos, si no existe manda mensaje de error
		if(login.isEmpty()){
				
			mensaje.add("El usuario no existe o la contraseña es incorrecta");
		}
		
		//Añade los mensajes de error al objecto ModelAndView para pasarlo al jsp
		maw.addObject("mensaje", mensaje);
		
		//Comprueba si se ha iniciado sesion, devuelve la vista de la tienda si esta logueado, si no le devuelve al login
        if (session.getAttribute("login") != null) {
        	
        	return maw1;
        	
        } else {
        	
        	//Comprueba que el usuario logueado es admin o no		
        	if(!login.isEmpty()) {
        		if(login.get(0).getAdmin() == 1) {
        			
        			//Si es admin le asigna el atributo de admin a la sesion
        			session.setAttribute("admin", email);
        			session.setAttribute("login", email);
                                        
                    return maw1;
        		} else {
        			
        			//Si no es admin solo añade el atributo a la sesion iniciada
        			session.setAttribute("login", email);
                                        
                    return maw1;
        		} 
        	} 
        	            
       		return maw;
        }
	}
	
	@RequestMapping("/carrito")
	public ModelAndView carritoIntranet(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		//Coge los datos del usuario activo para rellenar el formulario de direccion de envio
		List<User> users = BBDD.getUser(session.getAttribute("login"));
		
		//Recupera los datos de la sesion donde guarda los productos añadidos al carrito
		Object products = session.getAttribute("compra");
		ModelAndView maw = new ModelAndView("carrito");
		maw.addObject("user", users);
		
		//La lista de productos lo añade al MAW para printarlos en el carrito
		maw.addObject("compra", products);
		
		//Comprueba si se ha iniciado sesion, devuelve la vista del carrito si esta logueado, si no le devuelve al login
		if(session.getAttribute("login") != null) {
			
			return maw;

		} else {
			
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("/compra")
	public ModelAndView compraIntranet(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ModelAndView maw = new ModelAndView("carrito");
		Product product = new Product();
		Person person = new Person();		
		ArrayList<String> mensaje = new ArrayList<String>();
		ArrayList<String> producto = new ArrayList<String>();
		
		
		/* Validacion del formulario de compra, evalua si se han añadido productos al carrito y si todos los campos estan rellenos */
		person.setNombre(request.getParameter("nombre"));
		person.setApellidos(request.getParameter("apellidos"));
		person.setNacimiento(request.getParameter("nacimiento"));
		person.setTelefono(request.getParameter("telefono"));
		person.setDni(request.getParameter("dni"));
		person.setDireccion(request.getParameter("direccion"));
		person.setCp(request.getParameter("CP"));
		person.setCiudad(request.getParameter("ciudad"));
		person.setPrivado(request.getParameter("privado"));

		maw.addObject("person", person);
		
		//Si hay algun campo vacio envia mensaje de error
		if(person.getNombre() != null) {
			
			mensaje = person.validatePerson();
		} 
		
		//Si en la sesion de compra no hay productos manda mensaje de error
		if(session.getAttribute("compra") == null) {
			producto = product.validateProduct();
		}
		
		maw.addObject("producto", producto);
		maw.addObject("mensaje", mensaje);
		
		//Si no hay errores ingresa el pedido en la BBDD y retorna la vista de compra realizada
		if(mensaje.isEmpty() && producto.isEmpty()) {
			if(session.getAttribute("compra") != null) {
				
				Object products = session.getAttribute("compra");
				List<Product> productos2 = new ArrayList<Product>();
				@SuppressWarnings("unchecked")
				
				//Castea el objeto productos para meter los productos del carrito en una lista de productos
				List<Product> productos = (List<Product>) products;
				int productId = 0;
				
				//Coge el usuario activo para saber su id
				List<User> user = BBDD.getUser(session.getAttribute("login"));
				String userId = user.get(0).getId();
				double price = 0;
				int id_venta = 0;
				String nombre = "";
						
				//Con el id de usuario, busca el id de la venta, para poder asignar un nuevo id de venta al nuevo pedido
				List<Delivery> venta = BBDD.getDeliveryById(userId);
				if(venta.isEmpty()) {
					
					id_venta = 1;			
				} else {
					
					id_venta = (venta.get(venta.size() - 1).getId_venta()) + 1;	
				}

				//Itera la lista de productos comprados
				for(Product producto1 : productos) {
					
					//Busca el id y el precio del producto por su nombre
					productos2 = BBDD.getProductsByName(producto1.getNombre());
					productId = productos2.get(0).getId();
					price = productos2.get(0).getPrecio();
					nombre = productos2.get(0).getNombre();
					
					//Inserta en la BBDD el id de usuario,de producto y de venta y tambien ingresa el precio del producto
					BBDD.insertDelivery(userId, productId, price, id_venta, nombre);
				}
				
				//Una vez ingresado en la BBDD, borra los datos del carrito para hacer una nueva compra
				session.removeAttribute("compra");		
				return new ModelAndView("compra");
			}
		}
		return maw;
	}
	
	@RequestMapping("/admin")
	public ModelAndView adminIntranet(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ModelAndView maw = new ModelAndView("admin");
		
		//Coge los datos de todos los usuarios para imprimir los nombres en las options del select
		List<User> users = BBDD.getAllUsers();
		maw.addObject("users", users);
		//Al elegir un usuario, coge su id para imprimir sus pedidos
		Delivery delivery = new Delivery();
		delivery.setUsuarios_id(request.getParameter("cliente"));
		String id = delivery.getUsuarios_id();
		
		//Si se ha escogido un cliente, llama al metodo para regresar todos los pedidos realizados
		if(id != null) {
			 
			List<Delivery> lista = BBDD.getDelivery(id);
			maw.addObject("delivery", lista);
			return maw;
		}
		
		/*Comprueba si se ha iniciado sesion, despues, controla que el admin y el logueado sean el mismo, si es asi le devuelve 
		 la vista del admin */
		if(session.getAttribute("login") != null) {
			
			if(session.getAttribute("admin") == session.getAttribute("login")) {
			
				return maw;
			} 
		}
		
		return new ModelAndView("login");
	}
	
	@RequestMapping("/adminRest")
	public ModelAndView adminRestIntranet(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		ModelAndView maw = new ModelAndView("adminRest");
		String id = "";
		//Coge el mail de la sesion
		Object mail = session.getAttribute("login");
		//Busca al usuario y consigue su admin
		List<User> user = BBDD.getUser(mail);
		int admin = user.get(0).getAdmin();
		/* Si es igual a cero(no admin) manda la informacion del mismo usuario logueado, si es admin manda la info de todos 
		los usuarios */
		if(admin == 0) {
			maw.addObject("users", user);
			id = user.get(0).getId();
		} else {
			//Coge los datos de todos los usuarios para imprimir los nombres en las options del select
			List<User> users = BBDD.getAllUsers();
			maw.addObject("users", users);
			
			//Al elegir un usuario, coge su id para imprimir sus pedidos
			Delivery delivery = new Delivery();
			delivery.setUsuarios_id(request.getParameter("cliente"));
			id = delivery.getUsuarios_id();
		}
		
		//Si se ha escogido un cliente, llama al metodo para regresar todos los pedidos realizados
		if(id != null) {
			/* Hace llamada a la clase ClienteRest para hacer la llamada a la API y coger los productos de cada id e ingresa
			 todos los pedidos en una lista para mandarla al jstl */
			ClienteRest restClient = new ClienteRest();
			List<Delivery> lista = restClient.connectApi(id);
			
			maw.addObject("json", lista);
			
			return maw;
		}
		
		/*Comprueba si se ha iniciado sesion, despues, controla que el admin y el logueado sean el mismo, si es asi le devuelve 
		 la vista del admin */
		if(session.getAttribute("login") != null) {
			
//			if(session.getAttribute("admin") == session.getAttribute("login")) {
			
				return maw;
//			} 
		}
		
		return new ModelAndView("login");
	}
	
	@RequestMapping("/contacto")
	public ModelAndView contactoIntranet(HttpServletRequest request) {
		
		Contact contact = new Contact();
		ModelAndView maw = new ModelAndView("contacto");
		ArrayList<String> mensaje = new ArrayList<String>();
		
		/* Validacion del formulario de contacto */
		contact.setNombre(request.getParameter("nombre"));
		contact.setEmail(request.getParameter("email"));
		contact.setTelefono(request.getParameter("telefono"));
		contact.setMensaje(request.getParameter("mensaje"));
		
		maw.addObject("contacto", contact);

		//Si hay campos vacios manda mensaje de error
		if(contact.getNombre() != null) {
			
			mensaje = contact.validateContact();
		}
		
		maw.addObject("mensaje", mensaje);
		
		return maw;
	}
	
	//Controller para cerrar sesion	
	@RequestMapping("/logout")
	public ModelAndView logoutIntranet(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		//Cierra la sesion y si no ha comprado borra el carrito
		if(session.getAttribute("login") != null) {
			
			session.removeAttribute("login");
			session.removeAttribute("compra");
			
		} 
			
		return new ModelAndView("redirect:/login");
	}
}
