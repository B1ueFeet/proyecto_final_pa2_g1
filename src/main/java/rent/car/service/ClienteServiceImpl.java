package rent.car.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Cliente;
import rent.car.modelo.Reserva;
import rent.car.repository.IClienteRepository;
import rent.car.repository.IReservaRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IReservaRepository reservaRepository;

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
		this.clienteRepository.eliminar(id);

	}

	// BUSCAR APELLIDO
	@Override
	public List<Cliente> buscarApellido(String apellido) {
		return this.clienteRepository.buscarApellido(apellido);
	}

	@Override
	public Boolean autenticar(String user, String pass) {
		Cliente empleado = this.clienteRepository.buscarUser(user);
		System.out.println("Encontro el usuario");
		if (empleado == null) {
			return false;
		} else {
			System.out.println(empleado.getContrasenia());
			System.out.println(pass);
			if (empleado.getContrasenia().equals(pass)) {
				System.out.println("si es la contraseña");
				return true;
			} else {
				System.out.println("no es la contraseña");
				return false;
			}
		}
	}

	public List<Cliente> encontrarTodos() {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscarTodos();
	}

	public List<Cliente> clientesVIP() {
		List<Cliente> clientes = this.clienteRepository.buscarClientes();
		List<Cliente> clientesVIP = clientes.stream().sorted(Comparator.comparingDouble(
				a -> a.getReserva().parallelStream().map(b -> b.getTotal().doubleValue()).reduce(0.0, Double::sum)))
				.collect(Collectors.toList());
		clientesVIP.forEach(a -> {
			a.setContrasenia(this.calcularTotal(a).toString());
			a.setUsuario(this.calcularIva(a).toString());
		});
		Collections.reverse(clientesVIP);
		return clientesVIP;

	}

	public Double calcularIva(Cliente Cliente) {
		List<Reserva> lista = Cliente.getReserva();
		Double iva = lista.parallelStream().map(b -> b.getIva().doubleValue()).reduce(0.0, Double::sum);
		return iva;
	}

	public Double calcularTotal(Cliente Cliente) {
		List<Reserva> lista = Cliente.getReserva();
		Double iva = lista.parallelStream().map(b -> b.getTotal().doubleValue()).reduce(0.0, Double::sum);
		return iva;
	}

	@Override
	public Cliente encontrarCliente(Integer id) {
		// TODO Auto-generated method stub

		return this.clienteRepository.buscar(id);
	}

}
