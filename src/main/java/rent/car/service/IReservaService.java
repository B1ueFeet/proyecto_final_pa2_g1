package rent.car.service;


import rent.car.modelo.dto.ReservaDTO;

import java.time.LocalDateTime;

import rent.car.modelo.Reserva;


public interface IReservaService {
	
	public ReservaDTO retirarVehiculoReservado(Integer numeroReserva);

	// CRUD

	public void agregar(Reserva reserva);

	public void modificar(Reserva reserva);

	public Reserva encontrar(Integer id);

	public void borrar(Integer id);
	
	public void reservar(String placa,String cedula,LocalDateTime inicio, LocalDateTime fin);

}
