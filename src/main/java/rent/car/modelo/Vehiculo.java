package rent.car.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(generator = "seq_vehi", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, sequenceName = "seq_vehi", name = "seq_vehi")
	@Column(name = "vehi_id")
	private Integer id;
	@Column(name = "vehi_placa")
	private String placa;
	@Column(name = "vehi_modelo")
	private String modelo;
	@Column(name = "vehi_marca")
	private String marca;
	@Column(name = "vehi_anio")
	private String anio;
	@Column(name = "vehi_pais")
	private String pais;
	@Column(name = "vehi_estado")
	private String estado;
	@Column(name = "vehi_cilindraje")
	private String cilindraje;
	@Column(name = "vehi_avaluo")
	private String avaluo;
	@Column(name = "vehi_valor")
	private BigDecimal valor;

	// RELACIONES
	@OneToMany(mappedBy = "vehiculo", fetch = FetchType.EAGER)
	private List<Reserva> reserva;

	// GETTER & SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getAvaluo() {
		return avaluo;
	}

	public void setAvaluo(String avaluo) {
		this.avaluo = avaluo;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	// TO STRING
	// Placa: PFQ-0445 - Modelo: Sportage – Marca: KIA – Año: 2019 – Estado: No
	// Disponible – Valor por día: $80.00
//	return "Placa: " + placa + " - Modelo: " + modelo + " - Marca: " + marca + " - Año: " + anio + " - Estado="
//			+ estado + " - Valor=" + valor + "]";
//
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", anio=" + anio
				+ ", pais=" + pais + ", estado=" + estado + ", cilindraje=" + cilindraje + ", avaluo=" + avaluo
				+ ", valor=" + valor + "]";
	}
}
