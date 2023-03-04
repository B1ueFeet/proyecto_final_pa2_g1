package rent.car.repository;

import java.util.List;

import rent.car.modelo.Vehiculo;
import rent.car.modelo.dto.VehiculoDTO;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);
	public List<Vehiculo> buscarPorMarca(String marca);
	public Vehiculo buscar(Integer id);

	public List<Vehiculo> buscarPlaca(String placa);

	public void actualizar(Vehiculo vehiculo);
	public void eliminar(Integer id);
	
	// BUSCAR
	public List<Vehiculo> buscar(String marca, String modelo);

	// Actualizar estado de vehiculo por placa

	public Integer actualizarEstado(String placa);

	//Obtener un vehiculoDTO por placa
	public VehiculoDTO buscarPorPlaca(String placa);

}
