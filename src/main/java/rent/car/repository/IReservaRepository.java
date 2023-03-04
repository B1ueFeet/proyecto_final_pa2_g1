package rent.car.repository;

import rent.car.modelo.Reserva;
import rent.car.modelo.dto.ReservaDTO;

public interface IReservaRepository {

	// CRUD

	public void insertar(Reserva reserva);

	public void actualizar(Reserva reserva);

	public Reserva buscar(Integer id);

	public void eliminar(Integer id);

	// Para actualizar el estado de reserva

	public Integer actualizarEstado(Integer numeroReserva);

	// Obtener ReservaDTO por numero de reserva

	public ReservaDTO buscarPorNumero(Integer numeroReserva);
}