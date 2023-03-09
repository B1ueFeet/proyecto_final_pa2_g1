package rent.car.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {

	@Id
	@GeneratedValue(generator = "seq_vend", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, name = "seq_vend", sequenceName = "seq_vend")
	@Column(name = "vend_id")
	private Integer id;

	@Column(name = "vend_cedula")
	private String cedula;

	@Column(name = "vend_nombre")
	private String nombre;
	
	//Set Y Get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//To String

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + "]";
	}

}
