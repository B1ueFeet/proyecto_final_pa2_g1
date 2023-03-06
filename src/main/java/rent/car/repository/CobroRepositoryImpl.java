package rent.car.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import rent.car.modelo.Cobro;

@Repository
@Transactional
public class CobroRepositoryImpl implements ICobroRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Cobro cobro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cobro);
	}

}
