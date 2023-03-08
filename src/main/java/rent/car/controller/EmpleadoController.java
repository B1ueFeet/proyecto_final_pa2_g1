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

	// registro de un cliente
	@GetMapping("/cliente/registro")
	public String paginaInicio(Cliente cliente) {
		return "vRegistroClienteE";
	}

	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {
		this.clienteService.registrar("E", cliente);
		return "guardado";
	}

	// busqueda por apellido
	@GetMapping("/inicio/buscar/apellido")
	public String paginaBuscarCliente(Cliente cliente) {
		return "VistaBuscarClientesPorApellido";
	}

	@GetMapping("/lista/apellidos")
	public String buscarPorApellido(Cliente cliente, Model model) {
		List<Cliente> listCliente = this.clienteService.buscarApellido(cliente.getApellido());
		model.addAttribute("empleados", listCliente);
		return "vListaCliente";
	}

	// buscar todos
	@GetMapping("/lista")
	public String buscarClientes(Model model) {
		List<Cliente> lista = this.clienteService.encontrarTodos();
		model.addAttribute("empleados", lista);
		return "vListaCliente";
	}

	// Actualizar cliente
	@GetMapping("/cliente/ver/{id}")
	public String visualizarCliente(@PathVariable("id") Integer id, Model model) {
		Cliente cliente = this.clienteService.encontrarCliente(id);
		model.addAttribute("cliente", cliente);
		model.addAttribute("id", id);
		return "vistaVisualizarCliente";
	}

	// borrar
	@DeleteMapping("/cliente/borrar/{id}")
	public String borrarCliente(@PathVariable("id") Integer id) {
		this.clienteService.borrar(id);
		return "redirect:/empleados/lista";

	}

	// actualizar
	@PutMapping("actualizar/{apellido}")
	public String buscarPorApellido(@PathVariable("apellido") String apellido, Cliente cliente) {
		cliente.setApellido(apellido);
		this.clienteService.buscarApellido(apellido);
		return "redirect:/empleados/lista";

	}

	// ver cliente
	@GetMapping("/cliente/actualizar/{id}")
	public String buscarClienteporId(@PathVariable("id") Integer id, Model model) {
		Cliente cliente = this.clienteService.encontrarCliente(id);
		model.addAttribute("cliente", cliente);
		model.addAttribute("id", id);
		return "vistaCliente";
	}

	// actualizar cliente
	@PutMapping("/actualizar/cliente/{id}")
	public String actualizarPorIdCliente(@PathVariable("id") Integer id, Cliente cliente) {
		cliente.setId(id);
		// this.vehiculoService.actualizar(vehiculo);
		this.clienteService.actualizar(cliente);

		return "redirect:/empleados/lista";
	}

	// Vehiculo

	@GetMapping("/inicio/registrovehi") // va a tomar referencia a la raiz de nuestra aplicacion
	public String paginaInicio(Vehiculo vehiculo) {
		return "vRegistroVehiculo";
	}

	@PostMapping("/insertarV")
	public String insertarVehiculo(Vehiculo vehiculo) {
		vehiculo.setEstado("D");
		this.vehiculoService.guardar(vehiculo);
		return "guardado";
	}

	@GetMapping("/buscarV")
	public String buscarVehiculo(Model model) {
		List<Vehiculo> lista = this.vehiculoService.encontrarTodos();
		model.addAttribute("empleados", lista);
		return "vListaVehiculo";
	}

	@GetMapping("/visualizarVehiculo/{id}")
	public String visualizarVehiculo(@PathVariable("id") Integer id, Model model) {
		Vehiculo vehiculo = this.vehiculoService.encontrar(id);
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("id", id);
		return "vistaVisualizarVehiculo";
	}

	@DeleteMapping("/borrarV/{id}")
	public String borrarPersona(@PathVariable("id") Integer id) {
		this.vehiculoService.borrar(id);

		return "redirect:/empleados/buscarV";
	}

	// PARTE BUENA
	@GetMapping("/inicio/buscarVehiculo") // va a tomar referencia a la raiz de nuestra aplicacion
	public String paginaBuscarVehiculo(Vehiculo vehiculo) {
		return "VistaBuscarVehiculoPorMarca";
	}

	@GetMapping("/buscarPorMarca")
	public String buscarPorMarca(Vehiculo vehiculo, Model model) {
		List<Vehiculo> lista = this.vehiculoService.encontrarPorMarca(vehiculo.getMarca());
		model.addAttribute("empleados", lista);
		return "vListaVehiculo";
	}

	@PutMapping("actualizarPorMarca/{marca}")
	public String buscarPorMarca(@PathVariable("marca") String marca, Vehiculo vehiculo) {
		vehiculo.setMarca(marca);
		this.vehiculoService.encontrarPorMarca(marca);
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
		lista.forEach(System.out::println);
		model.addAttribute("vehiculos", lista);
		return "vListaReporteVVIP";
	}

	@GetMapping("/retirar")
	public String paginaBuscarReserva(Reserva reserva) {
		return "vRetiroVehiculo";
	}

	@PostMapping("/retirar/reserva")
	public String buscarReserva(String numero, Model model) {
		System.out.println("este es numero de registro " + numero);
		Reserva reservav = this.reservaService.buscarNumero(numero);
		this.reservaService.retirarVehiculoReservado(numero);
		return "redirect:/empleados/retirar";
	}

}
