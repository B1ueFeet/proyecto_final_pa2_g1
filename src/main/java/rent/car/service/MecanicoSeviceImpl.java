package rent.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Mecanico;
import rent.car.repository.IMecanicoRepo;

@Service
public class MecanicoSeviceImpl implements IMecanicoSevice {

	
	@Autowired
	private IMecanicoRepo iMecanicoRepo;
	
	@Override
	public void ingresarMecanico(Mecanico mecanico) {
		// TODO Auto-generated method stub
		this.iMecanicoRepo.ingresarMecanico(mecanico);
		
		
	}

}
