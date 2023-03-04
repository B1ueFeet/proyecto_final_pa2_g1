package rent.car.repository;

import java.util.List;

import rent.car.modelo.Cliente;
import rent.car.modelo.Vehiculo;
import rent.car.modelo.dto.VehiculoDTO;

public interface IClienteRepository {

	

	public Cliente buscar(String cedula);
	public void eliminar(String cedula );
	
	public List<VehiculoDTO> buscarVehiculosDisponibles(String marca, String modelo);
	public Vehiculo BuscarVehiculo(String placa);

	public void registrarseCliente(Cliente cliente);

	public void actualizarCliente(String cedula);
}
