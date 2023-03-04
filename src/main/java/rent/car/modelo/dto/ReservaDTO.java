package rent.car.modelo.dto;

public class ReservaDTO {

	private String placa;

	private String modelo;

	private String estado;

	private String fecha;

	private String cedula;

	public ReservaDTO() {
		
	}

	public ReservaDTO(String placa, String modelo, String estado, String cedula) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.estado = estado;
		this.cedula = cedula;
	}

	// To String
	@Override
	public String toString() {
		return "ReservaDTO [placa=" + placa + ", modelo=" + modelo + ", estado=" + estado + ", fecha=" + fecha
				+ ", cedula=" + cedula + "]";
	}

	// SET Y GET
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
