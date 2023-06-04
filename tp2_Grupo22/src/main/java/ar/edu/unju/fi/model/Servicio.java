package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Servicio {
	@NotBlank(message="Debe elegir un día")
	private String dia;
	@NotEmpty(message="El nombre del paseador no puede permanecer vacío")
	@Size(min=5, max=40, message="El nombre del paseador debe contener entre 5 y 40 caracteres")
	private String paseador;
	@Min(value=9, message="La hora mínima para empezar un horario de un paseador son a las 9")
	@Max(value=22, message="La hora máxima para empezar un horario de un paseador son a las 22")
	private int horainicio;
	@Min(value=10, message="La hora mínima para terminar un horario de un paseador son a las 9")
	@Max(value=24, message="La hora máxima para terminar un horario de un paseador son a las 22")
	private int horafin;
	
	
	//Constructor sin parametros
	public Servicio() {
		
	}
	
	//Constructor parametrizado
	public Servicio(String dia, String paseador, int horainicio, int horafin) {
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
	
	public int getHorainicio() {
		return horainicio;
	}



	public void setHorainicio(int horainicio) {
		this.horainicio = horainicio;
	}
	

	
	public int getHorafin() {
		return horafin;
	}



	public void setHorafin(int horafin) {
		this.horafin = horafin;
	}
	

}
