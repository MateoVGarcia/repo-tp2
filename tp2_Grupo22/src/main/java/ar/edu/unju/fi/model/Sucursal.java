package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Sucursal {
	private String nombre;	
	private String direccion;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate fechaInicio;
	private String email;
	private String telefono;
	private String wpp;
	 
	
	public Sucursal() {
		
	}	
	
	public Sucursal(String nombre, String direccion, LocalDate fechaInicio, String email,
			String telefono, String wpp) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
		this.wpp = wpp;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getWpp() {
		return wpp;
	}
	public void setWpp(String wpp) {
		this.wpp = wpp;
	}
	
	
}