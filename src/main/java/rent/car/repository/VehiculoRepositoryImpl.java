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
		this.entityManager.persist(vehiculo);
	}

	@Override
	public List<Vehiculo> buscarPorMarca(String marca) {
		Query query = this.entityManager.createNativeQuery("Select * from vehiculo where vehi_marca = :datoMarca",
				Vehiculo.class);
		query.setParameter("datoMarca", marca);
		return query.getResultList();
	}

	@Override
	public Vehiculo buscar(Integer id) {
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.entityManager.merge(vehiculo);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override

	public List<Vehiculo> buscar(String marca, String modelo) {
		TypedQuery<Vehiculo> query = this.entityManager.createQuery(
				"select v from Vehiculo v where c.marca = :datoMarca and c.modelo = datoModelo", Vehiculo.class);
		query.setParameter("datoMarca", marca);
		query.setParameter("datoModelo", modelo);
		return query.getResultList();
	// Actualizar estado de vehiculo por placa
	}
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

	public List<Vehiculo> buscarPlaca(String placa) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNativeQuery("Select * from vehiculo where vehi_placa = :datoPlaca",
				Vehiculo.class);
		query.setParameter("datoPlaca", placa);
		return query.getResultList();

	}

}
