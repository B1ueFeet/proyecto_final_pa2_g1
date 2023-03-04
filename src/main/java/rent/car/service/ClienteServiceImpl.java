package rent.car.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Cliente;
import rent.car.repository.IClienteRepository;
import rent.car.repository.IEmpleadoRepository;
@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;
	
	
	 @Override
		public void registrarComoCliente(String registro) {
			// TODO Auto-generated method stub
			
			Cliente cliente = new Cliente();
			cliente.setRegistro(registro);
					
			if (cliente.getRegistro().equals("C")) {
			clienteRepository.registrarseCliente(cliente);
			
			}
			
			
			
		}



	
	
}
