package rent.car.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Reserva;
import rent.car.modelo.Vehiculo;
import rent.car.repository.IClienteRepository;
import rent.car.repository.IReservaRepository;
import rent.car.repository.IVehiculoRepository;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired 
	private IReservaRepository reservaRepository;
	
	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
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

	@Override
	public void reservar(String placa, String cedula, LocalDateTime inicio, LocalDateTime fin) {
		// TODO Auto-generated method stub
		
		List<Vehiculo> vehiculo = this.vehiculoRepository.buscarPlaca(placa);
		
		
		
		if (vehiculo.get(0).getEstado() == "ND") {
            System.out.println("No se encontró ningún vehículo con la placa " + placa);
           
        }else {
        	System.out.println("VD");
        	
        	
        	inicio = LocalDateTime.now();
        	Reserva reserva = new Reserva();
        	reserva.setCliente(clienteRepository.buscar(cedula));
        	reserva.setVehiculo(vehiculo.get(0));
        	reserva.setEstado("G");
        	reserva.setFin(fin);
        	reserva.setInicio(inicio);
        	
        	
        	Integer dias ;
        	 
        	// Calcular dias
        	dias = Period.between(LocalDate.from(inicio), LocalDate.from(fin)).getDays();
        	BigDecimal subtotal = vehiculo.get(0).getValor().multiply(new BigDecimal(dias));
        	BigDecimal iva = subtotal.multiply(new BigDecimal(0.12));
        	
        	BigDecimal total = subtotal.add(iva);
        	
        	reserva.setSubtotal(subtotal);
        	reserva.setIva(iva);
        	reserva.setTotal(total);
        
        	this.reservaRepository.insertar(reserva);
        	
        }
        
		
		
        
		
		
	}
	
	

}
