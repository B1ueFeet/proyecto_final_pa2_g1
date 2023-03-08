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

	// CRUD
	@Override
	public void insertar(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);
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
		Vehiculo vehi = this.buscar(id);
		this.entityManager.remove(vehi);
	}

	// BUSCAR MARCA
	@Override
	public List<Vehiculo> buscarMarca(String marca) {
		Query query = this.entityManager.createNativeQuery("Select * from vehiculo where vehi_marca = :datoMarca",
				Vehiculo.class);
		query.setParameter("datoMarca", marca);
		return query.getResultList();
	}

	// BUSCAR MARCA, MODELO
	@Override
	public List<Vehiculo> buscarMarcaModelo(String marca, String modelo) {
		TypedQuery<Vehiculo> query = this.entityManager.createQuery(
				"select c from Vehiculo c where c.marca = :datoMarca and c.modelo = datoModelo", Vehiculo.class);
		query.setParameter("datoMarca", marca);
		query.setParameter("datoModelo", modelo);
		return query.getResultList();
	}

	// ACTUALIZAR LISTA POR PLACA
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
				"SELECT new rent.car.modelo.dto.VehiculoDTO(e.placa, e.modelo,"
						+ "e.marca, e.anio, e.estado, e.valor) from Vehiculo e WHERE e.placa = :datoPlaca",
				VehiculoDTO.class);

		typedQuery.setParameter("datoPlaca", placa);

		return typedQuery.getSingleResult();
	}

	// BUSCAR PLACA
	public Vehiculo buscarPlaca(String placa) {
		TypedQuery<Vehiculo> query = this.entityManager
				.createQuery("SELECT e from Vehiculo e WHERE e.placa = :datoPlaca", Vehiculo.class);
		query.setParameter("datoPlaca", placa);
		return query.getSingleResult();

	}

	@Override

	public List<Vehiculo> buscarTodos() {
		Query query = this.entityManager.createQuery("SELECT v FROM Vehiculo v");
		return query.getResultList();
	}

	public List<Vehiculo> reporteVehiculo() {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public List<Vehiculo> buscarTodosDisponibles() {
		Query query = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.estado=:datoDisp ");
		query.setParameter("datoDisp", "D");
		return query.getResultList();
	}

}
