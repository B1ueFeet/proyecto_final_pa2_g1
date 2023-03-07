package rent.car.service;

import java.util.List;

import rent.car.modelo.Vehiculo;

public interface IVehiculoService {

	// CRUD
	public void guardar(Vehiculo vehiculo);

	public Vehiculo encontrar(Integer id);

	public void actualizar(Vehiculo vehiculo);

	public void borrar(Integer id);
	
	// BUSCAR MARCA
	public List<Vehiculo> encontrarPorMarca(String marca);
	
	// BORRAR D
	public void borrarDisponible(Integer id, Boolean D);
	
	// BUSCAR MARCA, MODELO
	public List<Vehiculo> buscarMarcaModelo(String marca, String modelo);

	public List<Vehiculo> encontrarTodos();
}
