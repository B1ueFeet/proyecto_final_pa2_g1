package rent.car.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Reserva;
import rent.car.modelo.Vehiculo;
import rent.car.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	// CRUD
	@Override
	public void guardar(Vehiculo vehiculo) {
		this.vehiculoRepository.insertar(vehiculo);
	}

	@Override
	public Vehiculo encontrar(Integer id) {
		return this.vehiculoRepository.buscar(id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.vehiculoRepository.actualizar(vehiculo);
	}

	@Override
	public void borrar(Integer id) {
		this.vehiculoRepository.eliminar(id);
	}

	// BUSCAR MARCA
	@Override
	public List<Vehiculo> encontrarPorMarca(String marca) {
		return this.vehiculoRepository.buscarMarca(marca);
	}

	// BORRAR D
	@Override
	public void borrarDisponible(Integer id, Boolean D) {
		if (D) {
			borrar(id);
		} else {
			System.out.println("Vehículo no disponible, no es posible eliminar.");
		}
	}

	// BUSCAR MARCA, MODELO
	public List<Vehiculo> buscarMarcaModelo(String marca, String modelo) {
		return this.vehiculoRepository.buscarMarcaModelo(marca, modelo);

	}

	@Override

	public List<Vehiculo> buscarTodos() {
		return this.vehiculoRepository.buscarTodos();
	}

	@Override
	public Vehiculo buscarPlaca(String placa) {
		return this.vehiculoRepository.buscarPlaca(placa);
	}

	public List<Vehiculo> encontrarTodos() {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscarTodos();

	}

	@Override
	public List<Vehiculo> vehiculosVIP(LocalDateTime fecha) {
		// TODO Auto-generated method stub

		List<Vehiculo> vehiculos = this.vehiculoRepository.reporteVehiculo(fecha);
		List<Vehiculo> vehiculosVIP = vehiculos.stream()
				.sorted(Comparator.comparingDouble(
						a -> a.getReserva().stream().map(b -> b.getTotal().doubleValue()).reduce(0.0, Double::sum)))
				.collect(Collectors.toList());
		vehiculosVIP.parallelStream().forEach(a -> {
			a.setCilindraje(this.calcularSubtotal(a).toString());
			a.setValor(new BigDecimal(this.calcularTotal(a)));
		});
		Collections.reverse(vehiculosVIP);
		return vehiculosVIP;
	}

	public List<Vehiculo> buscarTodosDisponibles() {
		return this.vehiculoRepository.buscarTodosDisponibles();
	}

	@Override
	public Double calcularSubtotal(Vehiculo vehiculo) {
		List<Reserva> lista = vehiculo.getReserva();
		Double subTotal = lista.parallelStream().map(b -> b.getSubtotal().doubleValue()).reduce(0.0, Double::sum);
		return subTotal;
	}

	@Override
	public Double calcularTotal(Vehiculo vehiculo) {
		List<Reserva> lista = vehiculo.getReserva();
		Double total = lista.parallelStream().map(b -> b.getTotal().doubleValue()).reduce(0.0, Double::sum);
		return total;
	}

}
