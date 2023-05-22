package ar.edu.unju.fi.listas;

import java.util.List;

import ar.edu.unju.fi.model.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaSucursal{
	private List<Sucursal> sucursales;
	
	public ListaSucursal() {
		
		sucursales = new ArrayList<Sucursal>();
		sucursales.add(new Sucursal("Mora PetShop","Direccion", LocalDate.of(2020,10,10),"mora@petshop.com","+543885987654","https://chat.whatsapp.com/BlrmT1OHgIs2cBkuEkgMCW"));
		sucursales.add(new Sucursal("Mundo PetShop","Direccion",LocalDate.of(2020,2,7),"mundo@petshop.com","+543885321645","https://chat.whatsapp.com/BlrmT1OHgIs2cBkuEkgMCW"));
		sucursales.add(new Sucursal("DonCacho PetShop","Direccion",LocalDate.of(2020,3,11),"doncacho@petshop.com","+543885456123","https://chat.whatsapp.com/BlrmT1OHgIs2cBkuEkgMCW"));
	}

	public List<Sucursal> getSucursales(){
		return sucursales;
	}
	
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
}




 