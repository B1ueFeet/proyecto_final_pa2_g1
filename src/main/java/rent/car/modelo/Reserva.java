package rent.car.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rese")
	@SequenceGenerator(name = "seq_rese", sequenceName = "seq_rese", allocationSize = 1)
	@Column(name = "rese_id")
	private Integer id;

	@Column(name = "rese_numero")
	private String numero;

	@Column(name = "rese_fecha_inicio")
	private LocalDateTime inicio;

	@Column(name = "rese_fecha_fin")
	private LocalDateTime fin;

	@Column(name = "rese_subtotal")
	private BigDecimal subtotal;

	@Column(name = "rese_iva")
	private BigDecimal iva;

	@Column(name = "rese_total")
	private BigDecimal total;

	@Column(name = "rese_estado")
	private String estado;

	// RELACIONES
	@ManyToOne()
	@JoinColumn(name = "rese_id_cliente")
	private Cliente cliente;

	@ManyToOne()
	@JoinColumn(name = "rese_id_vehiculo")
	private Vehiculo vehiculo;

	@OneToOne(mappedBy = "reserva")
	private Cobro cobro;
	// GETTER & SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", numero=" + numero + ", inicio=" + inicio + ", fin=" + fin + ", subtotal="
				+ subtotal + ", iva=" + iva + ", total=" + total + ", estado=" + estado + ", cliente=" + cliente
				+ ", vehiculo=" + vehiculo + "]";
	}

}
