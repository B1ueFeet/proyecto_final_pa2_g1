package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import rent.car.modelo.Empleado;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	// CRUD
	@Override
	public void ingresar(Empleado empleado) {
		this.entityManager.persist(empleado);
	}

	@Override
	public Empleado buscar(Integer id) { 
		return this.entityManager.find(Empleado.class, id);
	}

}
