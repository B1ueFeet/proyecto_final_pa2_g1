package rent.car.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import rent.car.modelo.Usuario;

@Repository
@Transactional
public class UsuarioRepoImpl implements IUsuarioRepo {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(usuario);
	}

	
	
}
