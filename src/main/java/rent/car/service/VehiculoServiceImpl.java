package rent.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Vehiculo;
import rent.car.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Override
	public List<Vehiculo> buscar(String marca, String modelo) {
		return this.vehiculoRepository.buscar(marca, modelo);
	}

}
