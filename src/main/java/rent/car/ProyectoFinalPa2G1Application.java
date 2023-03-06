package rent.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rent.car.modelo.Vehiculo;
import rent.car.service.IVehiculoService;

@SpringBootApplication
public class ProyectoFinalPa2G1Application implements CommandLineRunner {

	

	@Autowired
	private IVehiculoService iVehiculoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalPa2G1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("...");
		
//		List<Vehiculo> listaVehiculos = this.iVehiculoService.buscarTodos();
//		listaVehiculos.forEach(v -> System.out.println(v));

	}

}
