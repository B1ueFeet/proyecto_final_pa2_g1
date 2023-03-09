package rent.car.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table
@Entity(name="mecanico")
public class Mecanico {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_meca")
	@SequenceGenerator(name = "seq_meca", sequenceName = "seq_meca", allocationSize = 1)
	@Column(name = "meca_id")
	private Integer id;
	
	
	@Column(name = "meca_cedula")
	private String cedula;

	@Column(name = "meca_nombre")
	private String nombre;

	@Column(name = "meca_apellido")
	private String apellido;
	
	
	

}
