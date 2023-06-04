package ar.edu.unju.fi.model;

public class Consejo {
	
	private String categoria;
	private String link;
	private String descripcion;
	
	
	public Consejo() {
		
	}
	
	public Consejo(String categoria, String link, String descripcion) {
		this.categoria = categoria;
		this.link = link;
		this.descripcion = descripcion;
	}
	
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
