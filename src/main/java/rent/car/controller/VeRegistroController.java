package rent.car.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rent.car.modelo.Reserva;
import rent.car.modelo.Vehiculo;
import rent.car.service.IReservaService;
import rent.car.service.IVehiculoService;


@Controller
@RequestMapping("/clientes")
public class VeRegistroController {

	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IReservaService iReservaService;
	
	@GetMapping("/reservar")
	public String paginaBuscarTodosVehiculos(Model model) {
		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
		model.addAttribute("vehiculos", listaVehiculos);
		return "vistaInicioReserva";
	}
	
	@GetMapping("/buscarplaca/{placa}")
	public String buscarPorPlaca(@PathVariable("placa") String placa, Model model) {
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(placa);
		System.out.println(vehiculo);
		model.addAttribute("vehiculo", vehiculo);
		return "vistaSecundariaReserva";
	}
	
//	//	public void reservar(String placa, String cedula, LocalDateTime inicio, LocalDateTime fin);
//
//	@PostMapping("/insertar/{cedula}")
//	public String insertarReserva(@PathVariable("cedula") String cedula, Model model) {
//		this.iReservaService.agregar(reserva);
//		return "vistaReserva";
//	}
	
//	@PostMapping("/insertar")
//	public String insertarReserva(Reserva reserva) {
//		this.iReservaService.agregar(reserva);
//		return "vistaReserva";
//	}
	

//	@PostMapping("/insertar")
//	public String insertarReserva(Model model) {
//		Reserva reserva = new Reserva();
//		model.addAttribute("reserva", reserva);
//		this.iReservaService.agregar(reserva);
//		return "vistaReserva";
//	}
//	
	
//	@GetMapping("/presentar")
//	public String paginaBuscarTodosVehiculos(Model model) {
//		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
//		List<String> placas = listaVehiculos.stream().map(v -> v.getPlaca()).collect(Collectors.toList());
//		placas.forEach(System.out::println);
//		
//		model.addAttribute("vehiculos", listaVehiculos);
//		return "vistaVehiPrueb";
//	}
}
