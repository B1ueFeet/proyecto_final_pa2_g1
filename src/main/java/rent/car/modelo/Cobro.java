package rent.car.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cobro")
public class Cobro {

	@Id
	@GeneratedValue(generator = "seq_cobr", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, name = "seq_cobr", sequenceName = "seq_cobr")
	@Column(name = "cobr_id")
	private Integer id;

	@Column(name = "cobr_fecha")
	private LocalDateTime fecha;

	@Column(name = "cobr_tarjeta")
	private String tarjeta;

	@OneToOne
	@JoinColumn(name = "cobr_id_reserva")
	private Reserva reserva;

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	// To String
	@Override
	public String toString() {
		return "Cobro [id=" + id + ", fecha=" + fecha + ", tarjeta=" + tarjeta + ", reserva=" + reserva + "]";
	}

}
