package rent.car.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Cliente;
import rent.car.modelo.Reserva;
import rent.car.modelo.Vehiculo;
import rent.car.modelo.dto.ReservaDTO;
import rent.car.repository.IClienteRepository;
import rent.car.repository.IReservaRepository;
import rent.car.repository.IVehiculoRepository;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaRepository reservaRepository;

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private ICobroService cobroService;

	// CRUD
	@Override
	public void agregar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.reservaRepository.insertar(reserva);
	}

	@Override
	public void modificar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.reservaRepository.actualizar(reserva);
	}

	@Override
	public Reserva encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.reservaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.reservaRepository.eliminar(id);
	}

	// RESERVAR
	@Override
	public void reservar(String placa, String cedula, LocalDateTime inicio, LocalDateTime fin, String numeroTarjeta) {
		// TODO Auto-generated method stub

		Vehiculo vehiculo = this.vehiculoRepository.buscarPlaca(placa);
		Cliente cliente = this.clienteRepository.BuscarCedula(cedula);

		if (vehiculo.getEstado() == "ND") {
			System.out.println("El Vehiculo esta ocupado en las fechas seleccionadas");

		} else {
			System.out.println("El vehiculo esta disponible");
			inicio = LocalDateTime.now();
			Reserva reserva = new Reserva();
			reserva.setCliente(cliente);
			reserva.setVehiculo(vehiculo);
			reserva.setEstado("G");
			reserva.setFin(fin);
			reserva.setInicio(inicio);

			Integer dias;

			// Calcular dias
			dias = Period.between(LocalDate.from(inicio), LocalDate.from(fin)).getDays();
			BigDecimal subtotal = vehiculo.getValor().multiply(new BigDecimal(dias));
			BigDecimal iva = subtotal.multiply(new BigDecimal(0.12));
			BigDecimal total = subtotal.add(iva);

			reserva.setSubtotal(subtotal);
			reserva.setIva(iva);
			reserva.setTotal(total);
			System.out.println("Costo total de la reserva: " + total + "$");

			reserva.setNumero("Res-" + reserva.getCliente().getId());

			// Guarda la reserva
			this.reservaRepository.insertar(reserva);

			// Reliza el cobro
			this.cobroService.realizarCobro(numeroTarjeta, reserva);
		}

	}

	// BUSCAR DTO
	public ReservaDTO retirarVehiculoReservado(String numeroReserva) {
		// TODO Auto-generated method stub
		ReservaDTO reservaDTO = this.reservaRepository.buscarPorNumero(numeroReserva);
		reservaDTO.setFecha(this.reservaRepository.buscar(numeroReserva).getInicio() + " - "
				+ this.reservaRepository.buscar(numeroReserva).getFin());
		this.reservaRepository.actualizarEstado(numeroReserva);
		this.vehiculoRepository.actualizarEstado(reservaDTO.getPlaca());

		return reservaDTO;
	}

	@Override
	public List<Reserva> reporteReserva(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		return this.reservaRepository.reportesReserva(fechaInicio, fechaFinal);
	}

	@Override
	public Reserva buscarNumero(String numero) {
		this.reservaRepository.buscarPorNumero(numero);
		return null;
	}

}
