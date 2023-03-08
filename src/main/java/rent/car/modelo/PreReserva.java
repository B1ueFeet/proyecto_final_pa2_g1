package rent.car.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pre_reserva")
public class PreReserva {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rese")
	@SequenceGenerator(name = "seq_rese", sequenceName = "seq_rese", allocationSize = 1)
	@Column(name = "pre_rese_id")
	private Integer id;

	@Column(name = "pre_rese_cedula")
	private String cedula;

	@Column(name = "pre_rese_fecha_inicio")
	private LocalDateTime inicio;

	@Column(name = "pre_rese_fecha_fin")
	private LocalDateTime fin;

	@Column(name = "pre_rese_placa")
	private String placa;

	@Column(name = "pre_rese_total")
	private BigDecimal total;

	@Column(name = "pre_rese_tarjeta")
	private String tarjeta;
	
	
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

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	
	
}
