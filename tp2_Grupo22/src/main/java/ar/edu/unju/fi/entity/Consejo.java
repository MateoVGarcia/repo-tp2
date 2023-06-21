package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Component
public class Consejo {
	@NotBlank(message="Debe seleccionar una categoria")
	private String categoria;
	@NotEmpty(message="No puede poner un link vacío")
	private String link;
	@NotEmpty(message="Necesita poner una descripción")
	private String descripcion;
	
	//Constructor sin parametros
	public Consejo() {
		
	}
	
	//Constructor parametrizado
	public Consejo(String categoria, String link, String descripcion) {
		this.categoria = categoria;
		//@NotNull
		this.link = link;
		//@NotNull
		this.descripcion = descripcion;
	}
	
	//Getters y setters
	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
