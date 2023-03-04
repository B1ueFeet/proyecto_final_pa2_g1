package rent.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Empleado;
import rent.car.repository.IEmpleadoRepository;

@Service
public class EpleadoServiceImpl implements IEmpleadoService {

	@Autowired
<<<<<<< HEAD
	private IEmpleadoRepository empleadoRepository;
	
=======
	private IEmpleadoRepository iEmpleadoRepository;

>>>>>>> 98b58857b85e453678e2516415489dca5c390acc
	@Override
	public void ingresar(Empleado empleado) {
		this.empleadoRepository.ingresar(empleado);
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		return this.buscarPorId(id);
	}

}
