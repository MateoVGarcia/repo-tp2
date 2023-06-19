package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class Servicio {
	@NotBlank(message="Debe elegir un día")
	private String dia;
	@NotEmpty(message="El nombre del paseador no puede permanecer vacío")
	@Size(min=5, max=40, message="El nombre del paseador debe contener entre 5 y 40 caracteres")
	private String paseador;
	@NotNull(message = "La hora de inicio no puede estar vacía")
	@Min(value=9, message="La hora mínima para empezar un horario de un paseador son a las 9")
	@Max(value=22, message="La hora mínima para empezar un horario de un paseador son a las 9")
	private Integer horainicio;
	@NotNull(message = "La hora de fin no puede estar vacía")
	@Min(value=10, message="La hora mínima para terminar un horario de un paseador son a las 10")
	@Max(value=24, message="La hora máxima para terminar un horario de un paseador son a las 24")
	private Integer horafin;
	
	
	//Constructor sin parametros
	public Servicio() {
		
	}
	
	//Constructor parametrizado
	public Servicio(String dia, String paseador, Integer horainicio, Integer horafin) {
		this.dia=dia;
		this.paseador=paseador;
		this.horainicio=horainicio;
		this.horafin=horafin;
	}
	
	//Getters y setters
	public String getDia() {
		return dia;
	}



	public void setDia(String dia) {
		this.dia = dia;
	}
	
	
	public String getPaseador() {
		return paseador;
	}



	public void setPaseador(String paseador) {
		this.paseador = paseador;
	}
	
	public Integer getHorainicio() {
		return horainicio;
	}



	public void setHorainicio(Integer horainicio) {
		this.horainicio = horainicio;
	}
	

	
	public Integer getHorafin() {
		return horafin;
	}



	public void setHorafin(Integer horafin) {
		this.horafin = horafin;
	}
	

}
