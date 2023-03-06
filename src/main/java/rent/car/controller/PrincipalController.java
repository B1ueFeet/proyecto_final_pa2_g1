package rent.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rent.car.modelo.Cliente;
import rent.car.service.IClienteService;
import rent.car.service.IEmpleadoService;

@Controller
@RequestMapping("/inicio")
//como regla general siempre se debe poner el recurso general en plural
//Manejo un recurso Persona

public class PrincipalController {

	@Autowired
	private IClienteService clienteService;
	@Autowired 
	private IEmpleadoService empleadoService;

	@GetMapping("")
	public String inicio(Cliente cliente) {
		return "vistaInicioSesion";
	}

	@GetMapping("/sesion") 
	public String paginaInicio(Cliente cliente) {

		return this.empleadoService.siguienteVista(cliente.getUsuario(), cliente.getContrasenia());
	}

	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {
		this.clienteService.registrar("E", cliente);
		return "guardado";
	}

}