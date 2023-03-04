package rent.car.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empl")
	@SequenceGenerator(name = "seq_empl", sequenceName = "seq_empl", allocationSize = 1)
	@Column(name = "empl_id")
	private Integer id;

	@Column(name = "empl_nombre")
	private String nombre;
	
	@Column(name = "empl_apellido")
	private String apellido;

	@Column(name = "empl_cedula")
	private String cedula;
	
	@Column(name = "empl_contrasenia")
	private String contrasenia;

	// toString
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", contrasenia=" + contrasenia + "]";
	}

	// Get y Set
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	
	
	
	

}
