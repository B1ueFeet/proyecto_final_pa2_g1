package rent.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.dto.ReservaDTO;
import rent.car.repository.IReservaRepository;
import rent.car.repository.IVehiculoRepository;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaRepository reservaRepository;

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public ReservaDTO retirarVehiculoReservado(Integer numeroReserva) {
		// TODO Auto-generated method stub
		ReservaDTO reservaDTO = this.reservaRepository.buscarPorNumero(numeroReserva);
		reservaDTO.setFecha(this.reservaRepository.buscar(numeroReserva).getInicio() + " - "
				+ this.reservaRepository.buscar(numeroReserva).getFin());
		this.reservaRepository.actualizarEstado(numeroReserva);
		this.vehiculoRepository.actualizarEstado(reservaDTO.getPlaca());

		return reservaDTO;
	}

}
