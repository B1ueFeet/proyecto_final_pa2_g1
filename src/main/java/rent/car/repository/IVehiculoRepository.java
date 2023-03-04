package rent.car.repository;

import java.util.List;

import rent.car.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);
	public List<Vehiculo> buscarPorMarca(String marca);
	public Vehiculo buscar(Integer id);
	public void actualizar(Vehiculo vehiculo);
	public void eliminar(Integer id);
	
	// BUSCAR
	public List<Vehiculo> buscar(String marca, String modelo);
}
