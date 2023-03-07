package rent.car.service;

import rent.car.modelo.Cobro;
import rent.car.modelo.Reserva;

public interface ICobroService {

	public String realizarCobro(String numeroTarjeta, Reserva reserva);
}
