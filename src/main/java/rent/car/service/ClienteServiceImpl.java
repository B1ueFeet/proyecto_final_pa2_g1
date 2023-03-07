package rent.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Cliente;
import rent.car.repository.IClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	// CRUD
	@Override
	public void registrar(String registro, Cliente cliente) {
		// TODO Auto-generated method stub
		cliente.setRegistro(registro);
		this.clienteRepository.insertar(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.clienteRepository.actualizar(cliente);
	}

	@Override
	public void borrar(Integer id) {

	}

	// BUSCAR APELLIDO
	@Override
	public List<Cliente> buscarApellido(String apellido) {
		return this.clienteRepository.buscarApellido(apellido);
	}

	@Override
	public List<Cliente> clientesVIP() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = this.clienteRepository.buscarClientes();

		return clientes;
	}

}
