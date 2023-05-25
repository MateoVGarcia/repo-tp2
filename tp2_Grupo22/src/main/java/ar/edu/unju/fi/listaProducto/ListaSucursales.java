package ar.edu.unju.fi.listaProducto;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;


import ar.edu.unju.fi.model.FormSucursal;


public class ListaSucursales {
	private List<FormSucursal> sucursales;
	
	public ListaSucursales() {
		sucursales = new ArrayList<FormSucursal>();
		sucursales.add(new FormSucursal("DonCacho PetShop","Av. Pres. Peron Nº1750","Jujuy",LocalDate.of(2020, 10, 10),"doncachojujuy@petshop.com","+543885761486"));
		sucursales.add(new FormSucursal("DonCachoTucu PetShop","Av. Roca Nº 2380","Tucuman",LocalDate.of(2020, 10, 10),"doncachotucu@petshop.com","+543815321645"));
		sucursales.add(new FormSucursal("DonCachoSalta PetShop","Av. Pres. Peron Nº2999","Salta",LocalDate.of(2020, 10, 10),"doncachosalta@petshop.com","+543875761486"));
	
	}
	
	public List<FormSucursal> getSucursales() {
		return sucursales;
	}
	
	public void setSucursales(List<FormSucursal> sucursales) {
		this.sucursales = sucursales;
	}
} 
