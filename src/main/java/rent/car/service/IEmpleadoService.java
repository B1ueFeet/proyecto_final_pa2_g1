package rent.car.service;

import rent.car.modelo.Empleado;

public interface IEmpleadoService {

	// CRUD
	public void ingresar(Empleado empleado);

	public Empleado buscarPorId(Integer id);

}
