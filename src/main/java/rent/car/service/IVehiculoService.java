package rent.car.service;

import java.util.List;

import rent.car.modelo.Vehiculo;

public interface IVehiculoService {

	public List<Vehiculo> buscar(String marca, String modelo);

}
