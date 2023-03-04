package rent.car.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import rent.car.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public List<Vehiculo> buscarPorMarca(String marca) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNativeQuery("Select * from vehiculo where vehi_marca = :datoMarca",
				Vehiculo.class);
		query.setParameter("datoMarca", marca);
		return query.getResultList();
	}

	@Override
	public Vehiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vehiculo);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public List<Vehiculo> buscar(String marca, String modelo) {
		TypedQuery<Vehiculo> query = this.entityManager.createQuery(
				"select v from Vehiculo v where c.marca = :datoMarca and c.modelo = datoModelo", Vehiculo.class);
		query.setParameter("datoMarca", marca);
		query.setParameter("datoModelo", modelo);
		return query.getResultList();
	}

}
