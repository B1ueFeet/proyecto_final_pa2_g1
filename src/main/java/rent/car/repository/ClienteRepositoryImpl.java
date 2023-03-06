package rent.car.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import rent.car.modelo.Cliente;
import rent.car.modelo.dto.ClienteDTO;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	// CRUD
	@Override
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);

	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	// BUSCRA APELLIDO
	@Override
	public List<Cliente> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.apellido= :datoApellido");
		query.setParameter("datoApellido", apellido);
		return query.getResultList();

	}

	// BUSCAR CEDULA
	@Override
	public Cliente BuscarCedula(String Cedula) {
		TypedQuery<Cliente> query = this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.cedula= :datoCedula", Cliente.class);
		query.setParameter("datoCedula", Cedula);
		return query.getSingleResult();
	}

	// Clientes VIP
	@Override
	public List<ClienteDTO> buscarClientes() {
		// TODO Auto-generated method stub
		TypedQuery<ClienteDTO> query = this.entityManager
				.createQuery("SELECT NEW rent.car.modelo.dto.ClienteDTO(c.cedula, c.nombre, c.apellido,"
						+ " r.iva, SUM(r.total)) FROM Cliente c JOIN c.reserva r"
						+ "GROUP BY  c.cedula, c.nombre, c.apellido, r.iva", ClienteDTO.class);
		return query.getResultList();
	}

}
