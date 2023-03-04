package rent.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Empleado;
import rent.car.repository.IEmpleadoRepository;

@Service
public class EpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoRepository iEmpleadoRepository;
	
	@Override
	public void ingresar(Empleado empleado) {
		this.iEmpleadoRepository.ingresar(empleado);
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		return this.buscarPorId(id);
	}

}
