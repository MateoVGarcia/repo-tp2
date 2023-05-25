package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class FormSucursal {
		private String nombre;
		private String direccion;
		private String provincia;
		private LocalDate fechaInicio;
		private String email;
		private String telefono;
		
	public FormSucursal() {
		// TODO Auto-generated constructor stub
	}	
	
	
		
		
		public FormSucursal(String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
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
		public String getProvincia() {
			return provincia;
		}
		public void setProvincia(String provincia) {
			this.provincia = provincia;
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
		
		
}
