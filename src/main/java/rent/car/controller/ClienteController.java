package rent.car.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rent.car.modelo.Cliente;
import rent.car.modelo.PreReserva;
import rent.car.modelo.Reserva;
import rent.car.modelo.Vehiculo;
import rent.car.service.PreReservaService;
import rent.car.service.IClienteService;
import rent.car.service.IReservaService;
import rent.car.service.IVehiculoService;

/**
	@GetMapping("/visualizar")
	public String paginaBuscarTodosVehiculos(Model model) {
		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
		model.addAttribute("vehiculos", listaVehiculos);
		return "vListaReserva";
	}

	
	@GetMapping("/buscarplaca/{placa}")
	public String buscarPorPlaca(@PathVariable("placa") String placa, Model model, Reserva reserva) {
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(placa);
		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("reserva", reserva);
		model.addAttribute("vehiculosDisponibles", listaVehiculos);
		return "vistaSecundariaReserva21";
	}
	
	@PostMapping("/insertar")
	public String insertarReserva(Reserva reserva) {
		
		reserva.setIva(new BigDecimal(0.12));
	
		this.iReservaService.agregar(reserva);
		return "vistaReserva";
	}


	@GetMapping("/registro")
	public String paginaInicio(Cliente cliente) {
		return "vRegistroClienteC";
	}

	@PostMapping("/insertar/cliente")
	public String insertarCliente(Cliente cliente) {
		this.iClienteService.registrar("C", cliente);
		return "redirect: /clientes/inicio";
	}
 */
@Controller
@RequestMapping("/clientes") // URL:   http://localhost:8085/clientes/reservar        http://localhost:8085/clientes/registro
public class ClienteController {

	LocalDateTime hi = null;
	LocalDateTime hf = null;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IReservaService iReservaService;

	@Autowired
	private IClienteService iClienteService;
	
	@Autowired
	private PreReservaService preReserva;

//	@GetMapping("/visualizar")
//	public String paginaBuscarTodosVehiculos(Model model) {
//		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
//		model.addAttribute("vehiculos", listaVehiculos);
//		return "vListaReserva";
//	}

	
	@GetMapping("/buscarplaca/{placa}")
	public String buscarPorPlaca(@PathVariable("placa") String placa, Model model, PreReserva preReserva) {
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(placa);
		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("reserva", preReserva);
		model.addAttribute("vehiculosDisponibles", listaVehiculos);
		return "vistaSecundariaReserva21";
	}
	
	
	//*******************************************************************************
	@GetMapping("/visualizar")
	public String paginaBuscarTodosVehiculos(Model model) {
		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
		model.addAttribute("vehiculos", listaVehiculos);
		return "vListaReserva";
	}

	
	@GetMapping("/consultar")
	public String consulta(Model model, PreReserva preReserva) {
		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
		List<Vehiculo> listaVehiculosDisponibles = this.iVehiculoService.buscarTodosDisponibles();
		model.addAttribute("reserva", preReserva);
		model.addAttribute("vehiculosDisponibles", listaVehiculos);
		model.addAttribute("listaVehiculosDisponibles", listaVehiculosDisponibles);

		return "vistaConsulta";
	}
	
	@PostMapping("/verificardatos")
	public String verificaDatos(PreReserva reserva, Model model) {
		hi = reserva.getInicio();
		hf = reserva.getFin();
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(reserva.getPlaca());
		reserva.setTotal(this.preReserva.reservar(vehiculo.getPlaca(), reserva.getInicio(), reserva.getFin()));
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("reserva", reserva);
		this.preReserva.guardar(reserva);
		return "vistaVerificacionDatos";
	}


	@PostMapping("/reservar")
	public String insertarReservado(PreReserva reserva) {
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(reserva.getPlaca());
		this.iReservaService.reservar(vehiculo.getPlaca(), "123456789", hi, hf, "132");
		return "vistaReservaCompletada";
	}
	
	//******************************************************************	
	
	
	@GetMapping("/registro")
	public String paginaInicio(Cliente cliente) {
		return "vRegistroClienteC";
	}

	@PostMapping("/insertar/cliente")
	public String insertarCliente(Cliente cliente) {
		this.iClienteService.registrar("C", cliente);
		return "redirect: /clientes/inicio";
	}

	
	

}
