package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import rent.car.modelo.Bodeguero;

@Transactional
@Repository
public class BodegueroRepoImpl implements IBodegueroRepo {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Bodeguero bodeguero) {
		this.manager.persist(bodeguero);

	}

}
