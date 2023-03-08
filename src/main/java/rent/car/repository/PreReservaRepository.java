package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import rent.car.modelo.PreReserva;

@Repository
@Transactional
public class PreReservaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	
	public void insertar(PreReserva pre) {
		this.entityManager.persist(pre);

	}
}
