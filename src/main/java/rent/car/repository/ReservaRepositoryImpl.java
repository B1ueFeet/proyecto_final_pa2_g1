package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import rent.car.modelo.Reserva;
import rent.car.modelo.dto.ReservaDTO;

@Transactional
@Repository
public class ReservaRepositoryImpl implements IReservaRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Reserva reserva) {
		this.manager.persist(reserva);
	}

	@Override
	public void actualizar(Reserva reserva) {
		this.manager.merge(reserva);
	}

	@Override
	public Reserva buscar(Integer id) {
		return this.manager.find(Reserva.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.manager.remove(this.buscar(id));
	}

	// Actualizr estado de reserva por el numero de reserva

	@Override
	public Integer actualizarEstado(Integer numeroReserva) {
		// TODO Auto-generated method stub
		Query query = this.manager.createNativeQuery("UPDATE rese_estado SET rese_estado = 'E' WHERE rese_id = :DatoId",
				Reserva.class);
		query.setParameter("datoId", numeroReserva);

		return query.executeUpdate();
	}

	// Obtener ReservaDTO por numero de reserva

	@Override
	public ReservaDTO buscarPorNumero(Integer numeroReserva) {
		// TODO Auto-generated method stub
		TypedQuery<ReservaDTO> typedQuery = this.manager.createQuery(
				"SELECT new ReservaDTO(e.placa, e.modelo, e.estado, e.cedula) from Reserva e WHERE e.id = :datoId",
				ReservaDTO.class);
		typedQuery.setParameter("datoId", numeroReserva);
		return typedQuery.getSingleResult();
	}

}
