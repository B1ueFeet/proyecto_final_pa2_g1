package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import rent.car.modelo.Jefe;

@Repository
@Transactional
public class JefeRepositoryImpl implements IJefeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void guardar(Jefe jefe) {
		this.entityManager.persist(jefe);
	}
	
	

}
