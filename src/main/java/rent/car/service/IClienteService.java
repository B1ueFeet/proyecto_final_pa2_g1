package rent.car.service;

import java.util.List;

import rent.car.modelo.Cliente;
import rent.car.modelo.dto.ClienteDTO;

public interface IClienteService {

	// CRUD
	public void registrar(String registro, Cliente cliente);

	public void actualizar(Cliente cliente);

	public void borrar(Integer id);

	// BUSCAR APELLIDO

	public List<Cliente> buscarApellido(String apellido);

	// Clientes VIP
	public List<ClienteDTO> clientesVIP();

}
