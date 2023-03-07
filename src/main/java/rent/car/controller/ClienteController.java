package rent.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rent.car.modelo.Cliente;
import rent.car.modelo.Reserva;
import rent.car.modelo.Vehiculo;
import rent.car.service.IClienteService;
import rent.car.service.IReservaService;
import rent.car.service.IVehiculoService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IReservaService iReservaService;

	@Autowired
	private IClienteService iClienteService;

	@GetMapping("/reservar")
	public String paginaBuscarTodosVehiculos(Model model) {
		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
		model.addAttribute("vehiculos", listaVehiculos);
		return "vListaReserva";
	}

	@GetMapping("/buscarplaca/{placa}")
	public String buscarPorPlaca(@PathVariable("placa") String placa, Model model, Reserva reserva) {
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(placa);
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("reserva", reserva);
		return "vistaSecundariaReserva2";
	}

	@PostMapping("/insertar")
	public String insertarReserva(Reserva reserva) {
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
}
