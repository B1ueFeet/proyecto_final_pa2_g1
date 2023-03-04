package rent.car.repository;

import rent.car.modelo.Reserva;

public interface IReservaRepository {
	
	// CRUD

	public void insertar(Reserva reserva);

	public void actualizar(Reserva reserva);

	public Reserva buscar(Integer id);

	public void eliminar(Integer id);

}
