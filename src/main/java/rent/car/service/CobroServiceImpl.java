package rent.car.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Cobro;
import rent.car.modelo.Reserva;
import rent.car.repository.ICobroRepository;

@Service
public class CobroServiceImpl implements ICobroService {

	@Autowired
	private ICobroRepository cobroRepository;

	@Override
	public String realizarCobro(String numeroTarjeta, Reserva reserva) {
		// TODO Auto-generated method stub
		Cobro cobro = new Cobro();
		cobro.setFecha(LocalDateTime.now());
		cobro.setTarjeta(numeroTarjeta);
		cobro.setReserva(reserva);

		this.cobroRepository.insertar(cobro);
		return cobro.getReserva().getNumero();
	}

}
