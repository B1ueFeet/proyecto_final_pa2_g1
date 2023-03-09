package rent.car.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rent.car.modelo.Jefe;

import rent.car.service.IJefeService;

@Controller
@RequestMapping("/jefes") // http://localhost:8085/jefes/visualizar
public class JefeController {

	@Autowired
	private IJefeService iJefeService;
	
	
	@GetMapping("/visualizar")
	public String paginaJefe(Model model, Jefe jefe) {
		model.addAttribute("jefe", jefe);
		return "vistaJEFE";
	}
	
	@PostMapping("/guardar")
	public String verificaDatos(Model model, Jefe jefe) {
		this.iJefeService.guardar(jefe);
		return "vistaJefeComple";
	}
}
