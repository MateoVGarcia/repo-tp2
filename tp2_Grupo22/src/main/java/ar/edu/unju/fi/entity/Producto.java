package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component

public class Producto {
	
	@NotBlank(message = "El nombre es obligatorio.")
	@Size(min=2, max=50 , message = "El nombre debe contener entre 5 y 50 caracteres.")
	private String nombre;
	
	
	@DecimalMin(value = "2", message = "El Codigo debe ser mayor a 2.")
	private int codigo;
	
	@NotNull(message = "El precio es obligatorio")
	@DecimalMin(value = "3.0", message = "El precio debe ser mayor a 3 pesos.")
        @DecimalMax(value = "900000.0", message = "El precio debe ser menor o igual a 900000 pesos.")
	private float precio;
	
	@NotNull(message = "Seleccione una categoria.")
	private String categoria;
	
	
	@Max(value = 50, message = "El descuento debe ser menor o igual a 50.")
	private int descuento;
	
	
	//Constructor sin parametros
	public Producto() {
		
	}
	
	//Contructor parametrizado
	public Producto(String nombre, int codigo, float precio, String categoria, int descuento) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.descuento = descuento;
    }



	
	//Getters and Setters
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public int getDescuento() {
		return descuento;
	}



	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	
	
	//Metodo para el descuento
	public double calcularDescuento() {
		double descuentoCalculado = 0.0;
		if (descuento > 0 && descuento <= 50) {
				descuentoCalculado = precio * (descuento / 100.0);
		   }
		   return precio - descuentoCalculado;
	}	
	
}
