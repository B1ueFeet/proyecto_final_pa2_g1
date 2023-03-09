package rent.car.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//SERGHY
@Entity
@Table(name = "bodeguero")
public class Bodeguero {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bode")
	@SequenceGenerator(name = "seq_bode", sequenceName = "seq_bode", allocationSize = 1)
	@Column(name = "bode_id")
	private Integer id;

	@Column(name = "bode_nombre")
	private String nombre;

	@Column(name = "bode_numero_bodega")
	private String numero;

	@Column(name = "bode_apellido")
	private String apellido;

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Bodeguero [id=" + id + ", nombre=" + nombre + ", numero=" + numero + ", apellido=" + apellido + "]";
	}

}
