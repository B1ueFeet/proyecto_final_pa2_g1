package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import rent.car.modelo.Mecanico;


@Repository
@Transactional
public class MecanicoRepoImpl implements IMecanicoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresarMecanico(Mecanico mecanico) {
		
		this.entityManager.persist(mecanico);
		
		
	}

}
