package rent.car.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "jefe")
public class Jefe {

	// una pag dentro de empleados para ingresar 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jef")
	@SequenceGenerator(name = "seq_jef", sequenceName = "seq_jef", allocationSize = 1)
	@Column(name = "jef_id")
	private Integer id;

	@Column(name = "jef_nombre")
	private String nombre;

	@Column(name = "jef_apellido")
	private String apellido;

	
	
	@Override
	public String toString() {
		return "Jefe [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
