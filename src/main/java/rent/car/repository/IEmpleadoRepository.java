package rent.car.repository;

import rent.car.modelo.Empleado;

public interface IEmpleadoRepository {
	
	public void ingresar(Empleado empleado);
	public Empleado buscarPorId(Integer id);

}
