package rent.car.service;

import rent.car.modelo.dto.ReservaDTO;

public interface IReservaService {
	
	public ReservaDTO retirarVehiculoReservado(Integer numeroReserva);
}
