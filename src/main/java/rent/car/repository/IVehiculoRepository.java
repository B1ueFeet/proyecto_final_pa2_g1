package rent.car.repository;

import java.util.List;

import rent.car.modelo.Vehiculo;
import rent.car.modelo.dto.VehiculoDTO;

public interface IVehiculoRepository {

	// CRUD
	public void insertar(Vehiculo vehiculo);

	public Vehiculo buscar(Integer id);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(Integer id);

	// BUSCAR MARCA, MODELO
	public List<Vehiculo> buscarMarcaModelo(String marca, String modelo);

	// BUSCAR MARCA
	public List<Vehiculo> buscarMarca(String marca);

	// BUSCAR PLACA
	public Vehiculo buscarPlaca(String placa);

	// Actualizar estado de vehiculo por placa
	public Integer actualizarEstado(String placa);

	// Obtener un vehiculoDTO por placa
	public VehiculoDTO buscarPorPlaca(String placa);
	
	public List<Vehiculo> buscarTodos();

}
