package rent.car.repository;

import rent.car.modelo.Empleado;

public interface IEmpleadoRepository {

	// CRUD

	public void ingresar(Empleado empleado);

	public Empleado buscar(Integer id);

	// BUSCAR POR USERNAME
	public Empleado buscarUser(String user);

}
