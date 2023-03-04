package rent.car.modelo.dto;

import java.math.BigDecimal;



public class VehiculoDTO {
	
	

	private String placa;
	private String modelo;
	private String marca;
	private String anio;
	private String estado;
	private BigDecimal valor;
	
	
	public VehiculoDTO(String placa,String modelo,String marca,String anio,String estado,BigDecimal valor) {
		
		super();
		this.placa=placa;
		this.modelo=modelo;
		this.marca=marca;
		this.anio=anio;
		this.estado=estado;
		this.valor=valor;
		
		
	}


}
