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

	// CRUD
	@Override
	public void guardar(Vehiculo vehiculo) {
		this.vehiculoRepository.insertar(vehiculo);
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

	// BUSCAR MARCA
	@Override
	public List<Vehiculo> encontrarPorMarca(String marca) {
		return this.vehiculoRepository.buscarMarca(marca);
	}

	// BORRAR D
	@Override
	public void borrarDisponible(Integer id, Boolean D) {
		if (D) {
			borrar(id);
		} else {
			System.out.println("Vehículo no disponible, no es posible eliminar.");
		}
	}

	// BUSCAR MARCA, MODELO
	public List<Vehiculo> buscarMarcaModelo(String marca, String modelo) {
		return this.vehiculoRepository.buscarMarcaModelo(marca, modelo);

	}

	@Override
	public List<Vehiculo> encontrarTodos() {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscarTodos();
	}

}
