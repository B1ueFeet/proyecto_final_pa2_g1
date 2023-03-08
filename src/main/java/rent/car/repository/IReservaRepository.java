package rent.car.repository;

import java.time.LocalDateTime;
import java.util.List;

import rent.car.modelo.Reserva;
import rent.car.modelo.dto.ReservaDTO;

public interface IReservaRepository {

	// CRUD

	public void insertar(Reserva reserva);

	public void actualizar(Reserva reserva);

	public Reserva buscar(Integer id);

	public void eliminar(Integer id);

	// Para actualizar el estado de reserva

	public Integer actualizarEstado(String numeroReserva);

	// Obtener ReservaDTO por numero de reserva

	public ReservaDTO buscarPorNumero(String numeroReserva);

	// Buscar reserva por numero de reserva

	public Reserva buscar(String numeroReserva);

	// Reporte reservas

	public List<Reserva> reportesReserva(LocalDateTime fechaInicial, LocalDateTime fechaFinal);

	// Buscar todas las reservas

	public List<Reserva> reservas();
}