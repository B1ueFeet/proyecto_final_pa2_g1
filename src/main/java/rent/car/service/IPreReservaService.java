package rent.car.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import rent.car.modelo.PreReserva;

public interface IPreReservaService {
	
	public void insertar(PreReserva preReserva);
	
	public BigDecimal reservar(String placa, LocalDateTime inicio, LocalDateTime fin);
}
