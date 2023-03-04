package rent.car.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import rent.car.modelo.Vehiculo;
import rent.car.modelo.dto.VehiculoDTO;

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

	// Actualizar estado de vehiculo por placa

	@Override
	public Integer actualizarEstado(String placa) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNativeQuery(
				"UPDATE vehi_estado SET vehi_estado = 'ND' WHERE vehi_placa = :datoPlaca", Vehiculo.class);
		query.setParameter("datoPlaca", placa);
		return query.executeUpdate();
	}

	// Obtener vehiculoDTO por placa
	@Override
	public VehiculoDTO buscarPorPlaca(String placa) {

		TypedQuery<VehiculoDTO> typedQuery = this.entityManager.createQuery(
				"SELECT new VehiculoDTO(e.placa, e.modelo,"
						+ "e.marca, e.anio, e.estado, e.valor) from Vehiculo e WHERE e.placa = :datoPlaca",
				VehiculoDTO.class);

		typedQuery.setParameter("datoPlaca", placa);

		return typedQuery.getSingleResult();
	}

}
