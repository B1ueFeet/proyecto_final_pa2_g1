package rent.car.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rent.car.modelo.Cliente;
import rent.car.modelo.Vehiculo;
import rent.car.service.IClienteService;
import rent.car.service.IReservaService;
import rent.car.service.IVehiculoService;

@Controller
@RequestMapping("/empleados")
//como regla general siempre se debe poner el recurso general en plural
//Manejo un recurso Persona

public class EmpleadoController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IVehiculoService vehiculoService;

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

	@GetMapping("/buscar")
	public String buscarClientes(Model model) {
		List<Cliente> lista = this.clienteService.encontrarTodos();
		model.addAttribute("empleados", lista);
		return "vistaListaEmpleadoCliente";
	}

	@DeleteMapping("/borrar/{id}")
	public String borrarCliente(@PathVariable("id") Integer id) {
		this.clienteService.borrar(id);
		return "redirect:/empleados/buscar";

	}

	@GetMapping("/buscarPorApellido/{apellido}")

	public String buscarPorApellido(@PathVariable("apellido") String apellido, Model model) {
		ArrayList<Cliente> cliente = (ArrayList<Cliente>) this.clienteService.buscarApellido(apellido);
		model.addAttribute("apellido", cliente);
		return "vistaActualizarEmpleadoCliente";
	}

	@PutMapping("actualizar/{apellido}")
	public String buscarPorApellido(@PathVariable("apellido") String apellido, Cliente cliente) {
		cliente.setApellido(apellido);
		this.clienteService.buscarApellido(apellido);
		return "redirect:/empleados/buscar";

	}
	// Vehiculo

	@GetMapping("/inicio/registrovehi") // va a tomar referencia a la raiz de nuestra aplicacion
	public String paginaInicio(Vehiculo vehiculo) {
		return "vistaRegistroVehiculo";
	}

	@PostMapping("/insertarV")
	public String insertarVehiculo(Vehiculo vehiculo) {
		this.vehiculoService.guardar(vehiculo);
		return "guardado";
	}

	@GetMapping("/buscarV")
	public String buscarVehiculo(Model model) {
		List<Vehiculo> lista = this.vehiculoService.encontrarTodos();
		model.addAttribute("empleados", lista);
		return "vistaListaVehiculoDH";
	}

	@DeleteMapping("/borrarV/{id}")
	public String borrarPersona(@PathVariable("id") Integer id) {
		this.vehiculoService.borrar(id);

		return "redirect:/empleados/buscarV";
	}

	@GetMapping("/reporteReservas")
	public String reporteReservas(Model model) {
		// this.reservaService.reporteReserva(null, null);
		return "vistaReporteReserva";
	}

}
