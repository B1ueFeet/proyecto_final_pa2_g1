package rent.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Bodeguero;
import rent.car.repository.IBodegueroRepo;

@Service
public class BodegueroServiceImpl implements IBodegueroService {

	@Autowired
	private IBodegueroRepo bodegueroRepo;

	@Override
	public void guardar(Bodeguero bodeguero) {
		// TODO Auto-generated method stub
		this.bodegueroRepo.insertar(bodeguero);

	}

}
