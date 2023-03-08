package rent.car.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.PreReserva;
import rent.car.modelo.Vehiculo;
import rent.car.repository.IVehiculoRepository;
import rent.car.repository.PreReservaRepository;

@Service
public class PreReservaService implements IPreReservaService{

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Autowired
	private PreReservaRepository preReservaRepository;
	
	public void insertar(PreReserva preReserva) {
		this.preReservaRepository.insertar(preReserva);
	}
	
	
	public BigDecimal reservar(String placa, LocalDateTime inicio, LocalDateTime fin) {
		Vehiculo vehiculo = this.vehiculoRepository.buscarPlaca(placa);
		Integer dias;

		// Calcular dias
		dias = Period.between(LocalDate.from(inicio), LocalDate.from(fin)).getDays();
		BigDecimal subtotal = vehiculo.getValor().multiply(new BigDecimal(dias));
		BigDecimal iva = subtotal.multiply(new BigDecimal(0.12));
		BigDecimal total = subtotal.add(iva);

		System.out.println("Calculo valor: " + total);
		return total;
	}


}
