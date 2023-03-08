package rent.car.controller;

import java.time.LocalDateTime;
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
import rent.car.modelo.Reserva;
import rent.car.modelo.Vehiculo;
import rent.car.service.IClienteService;
import rent.car.service.IReservaService;
import rent.car.service.IVehiculoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IVehiculoService vehiculoService;

	@Autowired
	private IReservaService reservaService;

	@GetMapping("/inicio")
	public String inicio() {
		return "vInicioE";
	}

	@GetMapping("/inicio/registro") // va a tomar referencia a la raiz de nuestra aplicacion
	public String paginaInicio(Cliente cliente) {
		return "vRegistroClienteE";
	}

	@GetMapping("/inicio/buscarCliente") // va a tomar referencia a la raiz de nuestra aplicacion
	public String paginaBuscarCliente(Cliente cliente) {
		return "VistaBuscarClientesPorApellido";
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
		return "vListaEmpleado";
	}

	@GetMapping("/visualizarCliente/{id}")
	public String visualizarCliente(@PathVariable("id") Integer id, Model model) {
		Cliente cliente = this.clienteService.encontrarCliente(id);
		model.addAttribute("cliente", cliente);
		model.addAttribute("id", id);
		return "vistaVisualizarCliente";
	}

	@DeleteMapping("/borrar/{id}")
	public String borrarCliente(@PathVariable("id") Integer id) {
		this.clienteService.borrar(id);
		return "redirect:/empleados/buscar";

	}

	@GetMapping("/buscarPorApellido")
	public String buscarPorApellido(Cliente cliente, Model model) {
		List<Cliente> listCliente = this.clienteService.buscarApellido(cliente.getApellido());
		model.addAttribute("empleados", listCliente);
		return "vListaEmpleado";
	}

	@PutMapping("actualizar/{apellido}")
	public String buscarPorApellido(@PathVariable("apellido") String apellido, Cliente cliente) {
		cliente.setApellido(apellido);
		this.clienteService.buscarApellido(apellido);
		return "redirect:/empleados/buscar";

	}

	@GetMapping("/buscarCporId/{id}")
	public String buscarClienteporId(@PathVariable("id") Integer id, Model model) {
		Cliente cliente = this.clienteService.encontrarCliente(id);
		model.addAttribute("cliente", cliente);
		model.addAttribute("id", id);
		return "vistaCliente";
	}

	@PutMapping("/actualizarC/{id}")
	public String actualizarPorIdCliente(@PathVariable("id") Integer id, Cliente cliente) {
		cliente.setId(id);
		// this.vehiculoService.actualizar(vehiculo);
		this.clienteService.actualizar(cliente);

		return "redirect:/empleados/buscarC";
	}

	// Vehiculo

	@GetMapping("/inicio/registrovehi") // va a tomar referencia a la raiz de nuestra aplicacion
	public String paginaInicio(Vehiculo vehiculo) {
		return "vRegistroVehiculo";
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
		return "vListaVehiculo";
	}

	@DeleteMapping("/borrarV/{id}")
	public String borrarPersona(@PathVariable("id") Integer id) {
		this.vehiculoService.borrar(id);

		return "redirect:/empleados/buscarV";
	}

	@GetMapping("/reporte/reservas")
	public String reporteReservas(Reserva Reserva) {
		return "vReporteReserva";
	}

	@PostMapping("/reporte/listaReservas")
	public String listaReporteReservas(LocalDateTime fechaInicio, LocalDateTime fechaFinal, Model model) {
		System.out.println("fechas: " + fechaFinal + " " + fechaInicio);
		List<Reserva> lista = this.reservaService.reporteReserva(fechaInicio, fechaFinal);
		model.addAttribute("reservas", lista);
		return "vListaReporteReserva";
	}

	@GetMapping("/buscarVporId/{id}")
	public String buscarVehiculoporId(@PathVariable("id") Integer id, Model model) {
		Vehiculo vehiculo = this.vehiculoService.encontrar(id);
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("id", id);
		return "vistaVehiculo";
	}

	@PutMapping("/actualizarV/{id}")
	public String actualizarPorId(@PathVariable("id") Integer id, Vehiculo vehiculo) {
		vehiculo.setId(id);
		this.vehiculoService.actualizar(vehiculo);
		return "redirect:/empleados/buscarV";
	}

	@GetMapping("/reporte/listaClientesVIP")
	public String reporteClientesVIP(Model model) {
		List<Cliente> lista = this.clienteService.clientesVIP();
		model.addAttribute("empleados", lista);

		return "vListaReporteCVIP";
	}

	@GetMapping("/reporte/vehiculosVIP")
	public String reporteVehiculosVIP(Reserva Reserva) {
		return "vReporteVehiculosVIP";
	}

	@PostMapping("/reporte/listaVehiculosVIP")
	public String listaReporteVehiculosVIP(LocalDateTime fecha, Model model) {
		System.out.println("fecha:" + fecha);
		List<Vehiculo> lista = this.vehiculoService.vehiculosVIP(fecha);
		model.addAttribute("reservas", lista);
		return "vListaReporteVVIP";
	}

	@GetMapping("/retirar") // va a tomar referencia a la raiz de nuestra aplicacion
	public String paginaBuscarReserva(Reserva reserva) {
		return "vRetiroVehiculo";
	}

	@PostMapping("/retirar/reserva")
	public String buscarReserva(String numero, Model model) {
		System.out.println("este es numero de registro " + numero);
		Reserva reserva = this.reservaService.buscarNumero(numero);
		model.addAttribute("reserva", reserva);
		return "redirect:/empleados/retirar";
	}

}
