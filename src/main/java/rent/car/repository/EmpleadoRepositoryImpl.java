package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import rent.car.modelo.Empleado;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresar(Empleado empleado) {
		this.entityManager.persist(empleado);
	}

	@Override
	public Empleado buscarPorId(Integer id) {  //El id es integer, ver qpx
		return this.entityManager.find(Empleado.class, id);
	}

}
