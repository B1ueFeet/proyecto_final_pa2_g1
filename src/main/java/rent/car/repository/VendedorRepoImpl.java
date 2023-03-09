package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import rent.car.modelo.Vendedor;

@Repository
@Transactional
public class VendedorRepoImpl implements IVendedorRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vendedor vendedor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vendedor);
	}

}
