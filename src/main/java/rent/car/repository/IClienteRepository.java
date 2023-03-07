package rent.car.repository;

import java.util.List;

import rent.car.modelo.Cliente;

public interface IClienteRepository {

	// CRUD

	public Cliente buscar(Integer id);

	public void eliminar(Integer id);

	public void insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public List<Cliente> buscarTodos();

	// BUSCAR APELLIDO
	public List<Cliente> buscarApellido(String apellido);

	// BUSCAR CEDULA
	public Cliente BuscarCedula(String Cedula);

	// BUSCAR POR USERNAME
	public Cliente buscarUser(String user);

	// Clientes VIP

	public List<Cliente> buscarClientes();

}
