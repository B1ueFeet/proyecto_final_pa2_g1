package rent.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rent.car.modelo.Cliente;
import rent.car.service.IClienteService;
import rent.car.service.IReservaService;

@Controller
@RequestMapping("/empleados")
//como regla general siempre se debe poner el recurso general en plural
//Manejo un recurso Persona

public class EmpleadoController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IReservaService reservaService;

	@GetMapping("/inicio")
	public String inicio() {
		return "vistaInicioEmpleado";
	}

	@GetMapping("/inicio/registro") // va a tomar referencia a la raiz de nuestra aplicacion
	public String paginaInicio(Cliente cliente) {

		return "vistaGClienteEmpleado";
	}

	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {
		this.clienteService.registrar("E", cliente);
		return "guardado";
	}

	@GetMapping("/reporteReservas")
	public String reporteReservas(Model model) {
		//this.reservaService.reporteReserva(null, null);
		return "vistaReporteReserva";
	}

}
