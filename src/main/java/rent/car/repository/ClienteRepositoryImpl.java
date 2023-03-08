package rent.car.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import rent.car.modelo.Cliente;

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
		Cliente cli = this.buscar(id);
		this.entityManager.remove(cli);
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
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return query.getResultList().get(0);
		}
	}

	// BUSCAR USER
	@Override
	public Cliente buscarUser(String user) {
		TypedQuery<Cliente> query = this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.usuario = :datoUsuario", Cliente.class);
		query.setParameter("datoUsuario", user);

		try {
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("No se encontro el usuario");
			return null;

		}
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("select e from Cliente e");
		return query.getResultList();
	}

	// Clientes VIP
	@Override
	public List<Cliente> buscarClientes() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = this.entityManager.createQuery("SELECT c FROM Cliente c JOIN c.reserva r",
				Cliente.class);
		return query.getResultList();
	}

	@Override
	public Cliente encontrarCliente(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

}
