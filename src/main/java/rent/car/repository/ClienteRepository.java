package rent.car.repository;

import java.util.List;



import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import rent.car.modelo.Cliente;
import rent.car.modelo.Vehiculo;
import rent.car.modelo.dto.VehiculoDTO;

@Repository
@Transactional
public class ClienteRepository implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<VehiculoDTO> buscarVehiculosDisponibles(String marca, String modelo) {

		TypedQuery<VehiculoDTO> query = this.entityManager.createQuery(
				"SELECT NEW rent.car.modelo.dto.VehiculoDTO"
						+ "(v.placa,v.modelo, v.marca, v.anio, v.estado, v.valor) FROM Vehiculo v "
						+ "WHERE v.marca=:datoMarca and v.modelo=:datoModelo and v.estado= 'Disponible' ",
				VehiculoDTO.class);

		query.setParameter("datoMarca", marca);
		query.setParameter("datoModelo", modelo);

		return query.getResultList();

	}

	@Override
	public Vehiculo BuscarVehiculo(String placa) {

		TypedQuery<Vehiculo> query = this.entityManager
				.createQuery("SELECT v FROM Vehiculo v WHERE v.placa= :datoPlaca", Vehiculo.class);
		query.setParameter("datoPlaca", placa);
		return query.getSingleResult();
	}

	@Override
	public void registrarseCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);

	}


	
	@Override
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		Query query= this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula= :datoCedula");
		query.setParameter("datoCedula", cedula);
		return (Cliente) query.getSingleResult();

	}


	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Query query= this.entityManager.createNativeQuery("DELETE FROM cliente WHERE clie_cedula=:datoCedula", Cliente.class);
		query.setParameter("datoCedula", cedula);
		query.executeUpdate();

	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

}
