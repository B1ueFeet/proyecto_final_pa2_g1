package rent.repository;

import java.util.List;

import rent.car.modelo.Cliente;
import rent.car.modelo.Vehiculo;
import rent.car.modelo.dto.VehiculoDTO;




public interface IClienteRepository {

	
	public List<VehiculoDTO> buscarVehiculosDisponibles(String marca,String modelo);
	public Vehiculo BuscarVehiculo(String placa );
	public void registrarseCliente(Cliente cliente);
	public  void actualizarCliente(Cliente cliente);
}
