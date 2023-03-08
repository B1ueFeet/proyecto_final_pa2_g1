package rent.car.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rent.car.modelo.PreReserva;
import rent.car.modelo.Vehiculo;
import rent.car.service.IClienteService;
import rent.car.service.IPreReservaService;
import rent.car.service.IReservaService;
import rent.car.service.IVehiculoService;

@Controller
@RequestMapping("/clientes") // URL: http://localhost:8085/clientes/visualizar
								// http://localhost:8085/clientes/consultar
public class ClienteController {

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IReservaService iReservaService;

	@Autowired
	private IClienteService iClienteService;

	@Autowired
	private IPreReservaService preReservaService;

	LocalDateTime hi = null;
	LocalDateTime hf = null;
	String ced = null;

	// *******************************************************************************
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
	public String verificaDatos(PreReserva preReserva, Model model) {
		hi = preReserva.getInicio();
		hf = preReserva.getFin();
		ced = preReserva.getCedula();
//		System.out.println(reserva.getCedula());
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(preReserva.getPlaca());
		preReserva.setTotal(
				this.preReservaService.reservar(vehiculo.getPlaca(), preReserva.getInicio(), preReserva.getFin()));
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("reserva", preReserva);
		this.preReservaService.insertar(preReserva);
		return "vistaVerificacionDatos";
	}

	@PostMapping("/reservar")
	public String insertarReservado(PreReserva preReserva) {
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(preReserva.getPlaca());
		this.iReservaService.reservar(vehiculo.getPlaca(), ced, hi, hf, preReserva.getTarjeta());
		return "vistaReservaCompletada";
	}

}
