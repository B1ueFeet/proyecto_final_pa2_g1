package rent.car.service;

import rent.car.modelo.Empleado;

public interface IEmpleadoService {

	// CRUD
	public void ingresar(Empleado empleado);

	public Empleado buscarPorId(Integer id);
	
	// VERIFICAR USUARIO
	public Boolean autenticar(String user, String pass);
	
	//pasar siguiente vista 
	public String siguienteVista(String user, String pass);

}
