package rent.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.car.modelo.Vendedor;
import rent.car.repository.IVendedorRepo;

@Service
public class VendedorServiceImpl implements IVendedorService {

	@Autowired
	private IVendedorRepo vendedorRepo;

	@Override
	public void guardar(Vendedor vendedor) {
		// TODO Auto-generated method stub
		this.vendedorRepo.insertar(vendedor);
	}

}
