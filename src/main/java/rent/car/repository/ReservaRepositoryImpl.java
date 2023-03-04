package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import rent.car.modelo.Reserva;

@Transactional
@Repository
public class ReservaRepositoryImpl implements IReservaRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Reserva reserva) {
		this.manager.persist(reserva);
	}

	@Override
	public void actualizar(Reserva reserva) {
		this.manager.merge(reserva);
	}

	@Override
	public Reserva buscar(Integer id) {
		return this.manager.find(Reserva.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.manager.remove(this.buscar(id));
	}

}
