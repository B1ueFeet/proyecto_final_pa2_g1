package rent.car.service;

import java.time.LocalDateTime;
import java.util.List;

import rent.car.modelo.Reserva;
import rent.car.modelo.dto.ReservaDTO;

public interface IReservaService {

	// CRUD
	public void agregar(Reserva reserva);

	public void modificar(Reserva reserva);

	public Reserva encontrar(Integer id);

	public void borrar(Integer id);

	// RESERVAR
	public void reservar(String placa, String cedula, LocalDateTime inicio, LocalDateTime fin, String numeroTarjeta);

	// BUSCAR DTO
	public ReservaDTO retirarVehiculoReservado(String numeroReserva);

	// Reporte de reservas

	public List<Reserva> reporteReserva(LocalDateTime fechaInicio, LocalDateTime fechaFinal);

}
