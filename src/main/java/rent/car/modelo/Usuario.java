package rent.car.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usu")
	@SequenceGenerator(name = "seq_usu", sequenceName = "seq_usu", allocationSize = 1)
	@Column(name = "usu_id")
	private Integer id;
	
	@Column(name = "usu_nombre")
	private String nombre;
	
	
	@Column(name = "usu_apellido")
	private String apellido;
	
	
	
}
