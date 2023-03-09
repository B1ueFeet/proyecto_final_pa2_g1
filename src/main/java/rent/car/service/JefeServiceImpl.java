package rent.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Jefe;
import rent.car.repository.IJefeRepository;

@Service
public class JefeServiceImpl implements IJefeService{

	@Autowired
	private IJefeRepository iJefeRepository;
	
	@Override
	public void guardar(Jefe jefe) {
		this.iJefeRepository.guardar(jefe);
	}

}
