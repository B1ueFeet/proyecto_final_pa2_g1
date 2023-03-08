package rent.car.service;

import java.time.LocalDateTime;
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

	// BORRAR DISPONIBLE
	public void borrarDisponible(Integer id, Boolean D);

	// BUSCAR MARCA, MODELO
	public List<Vehiculo> buscarMarcaModelo(String marca, String modelo);

	// BUSCAR TODOS:
	public List<Vehiculo> buscarTodos();

	// BUSCAR PLACA
	public Vehiculo buscarPlaca(String placa);

	public List<Vehiculo> encontrarTodos();
<<<<<<< HEAD

	// Vehiculos VIP
	public List<Vehiculo> vehiculosVIP(LocalDateTime fecha);
=======
	
	public  List<Vehiculo> buscarTodosDisponibles();

>>>>>>> refs/remotes/origin/juan6
}
