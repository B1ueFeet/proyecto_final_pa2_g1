package rent.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Usuario;
import rent.car.repository.IUsuarioRepo;

@Service
public class UsuarioServiceImpl  implements IUsuarioService{

	
	@Autowired
	private IUsuarioRepo iUsuarioRepo;
	@Override
	public void agregar(Usuario usuario) {
		// TODO Auto-generated method stub
		this.iUsuarioRepo.insertar(usuario);
	}

}
