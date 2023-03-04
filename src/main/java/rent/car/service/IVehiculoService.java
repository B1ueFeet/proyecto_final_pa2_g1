package rent.car.service;

import java.util.List;

import rent.car.modelo.Vehiculo;

public interface IVehiculoService {

	public void guardar(Vehiculo vehiculo);
	public List<Vehiculo> encontrarPorMarca(String marca);
	public Vehiculo encontrar(Integer id);
	public void actualizar(Vehiculo vehiculo);
	public void borrar(Integer id);
	
	public void borrarDisponible(Integer id, Boolean D);
	
}
