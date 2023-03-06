package rent.car.repository;

import java.time.LocalDateTime;
import java.util.List;

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
	public Integer actualizarEstado(String numeroReserva) {
		// TODO Auto-generated method stub
		Query query = this.manager.createNativeQuery(
				"UPDATE rese_estado SET rese_estado = 'E' WHERE rese_numero = :datoNumero", Reserva.class);
		query.setParameter("datoNumero", numeroReserva);

		return query.executeUpdate();
	}

	// Obtener ReservaDTO por numero de reserva

	@Override
	public ReservaDTO buscarPorNumero(String numeroReserva) {
		// TODO Auto-generated method stub
		TypedQuery<ReservaDTO> typedQuery = this.manager.createQuery(
				"SELECT new rent.car.modelo.dto.ReservaDTO(e.placa, e.modelo, e.estado, e.cedula) from Reserva e WHERE e.numero = :datoNumero",
				ReservaDTO.class);
		typedQuery.setParameter("datoNumero", numeroReserva);
		return typedQuery.getSingleResult();
	}

	// Obtener reserva por numero de reserva

	@Override
	public Reserva buscar(String numeroReserva) {
		// TODO Auto-generated method stub

		Query query = this.manager.createNativeQuery("SELECT * FROM reserva WHERE rese_numero = :datoNumero",
				Reserva.class);
		query.setParameter("datoNumero", numeroReserva);
		return (Reserva) query.getSingleResult();
	}

	@Override
	public List<Reserva> reportesReserva(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {

		TypedQuery<Reserva> query = this.manager
				.createQuery("SELECT r.id, r.fechaInicio, r.fechaFin, r.descripcion, r.estado,"
						+ " c.nombre, c.apellido, v.marca, v.modelo, v.patente"
						+ " FROM Reserva r JOIN r.cliente c JOIN r.vehiculo v JOIN r.cobro co"
						+ " WHERE co.fecha BETWEEN  :datoFechaInicio AND :datoFechaFinal", Reserva.class);
		query.setParameter("datoFechaInicio", fechaInicial);
		query.setParameter("datoFechaFinal", fechaFinal);

		return query.getResultList();
	}

}
