package rent.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rent.car.modelo.Bodeguero;
import rent.car.service.IBodegueroService;

@Controller
@RequestMapping("/bodegueros")
public class BodegueroController {

	@Autowired
	private IBodegueroService bodegueroService;

	@GetMapping("/registro")
	public String paginaInicio(Bodeguero bodeguero) {
		return "vRegistroBodegero";
	}

	@PostMapping("/insertar")
	public String insertarCliente(Bodeguero bodeguero) {
		this.bodegueroService.guardar(bodeguero);
		return "guardado";
	}
}
