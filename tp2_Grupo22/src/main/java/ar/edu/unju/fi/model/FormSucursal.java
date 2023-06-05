package ar.edu.unju.fi.model;
 
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
@Component
public class FormSucursal {
		@NotEmpty(message="El nombre no puede estar vacio")
		private String nombre;
		@NotEmpty(message="El espacio direccion no puede estar vacio")
		@Size(max=80)
		private String direccion;
		@NotBlank(message="No olvide Seleccionar una provincia")
		private String provincia;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		@NotNull(message="La fecha no puede estar vacio")
		@Past(message="La fecha no debe ser igual o posterior a la actual")
		private LocalDate fechaInicio;
		@Email(message="Debe ingresar un email con formato valido Ej. empty@petshop.com")
		@NotEmpty(message="El email no puede estar vacio")
		private String email;
		@Size(min=10, max=13, message="Ingresar numero con +54 y la caracteristica de la provincia")
		private String telefono;
		@Min (value=1, message="El valor minimo permitido es 1")
		@Max(value=30, message="El valor maximo permiido es 20")
		@Positive(message="Ingresar solo valores mayodes a 0(cero)")
		private int empleados;
		
	public FormSucursal() {
		// TODO Auto-generated constructor stub
	}	
	
	
		
		
		public FormSucursal(String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono, int empleados) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
		this.empleados = empleados;
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
		public int getEmpleados() {
			return empleados;
		}
		public void setEmpleados(int empleados) {
			this.empleados = empleados;
		}
		
		
}
