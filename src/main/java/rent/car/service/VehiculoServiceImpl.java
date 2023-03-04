package rent.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Vehiculo;
import rent.car.repository.IVehiculoRepository;

@Service
<<<<<<< HEAD
public class VehiculoServiceImpl implements IVehiculoService{

=======
public class VehiculoServiceImpl implements IVehiculoService {
>>>>>>> 98b58857b85e453678e2516415489dca5c390acc
	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Override
<<<<<<< HEAD
	public void guardar(Vehiculo vehiculo) {
		this.vehiculoRepository.insertar(vehiculo);
	}

	@Override
	public List<Vehiculo> encontrarPorMarca(String marca) {
		return this.vehiculoRepository.buscarPorMarca(marca);
	}

	@Override
	public Vehiculo encontrar(Integer id) {
		return this.vehiculoRepository.buscar(id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.vehiculoRepository.actualizar(vehiculo);
	}

	@Override
	public void borrar(Integer id) {
		this.vehiculoRepository.eliminar(id);
	}

	@Override
	public void borrarDisponible(Integer id, Boolean D) {
		if (D) {
			borrar(id);
		} else {
			System.out.println("Vehículo no disponible, no es posible eliminar.");
		}
		
=======
	public List<Vehiculo> buscar(String marca, String modelo) {
		return this.vehiculoRepository.buscar(marca, modelo);
>>>>>>> 98b58857b85e453678e2516415489dca5c390acc
	}

}
