package ar.edu.unju.fi.listas;

import java.util.List;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import ar.edu.unju.fi.model.FormSucursal;

@Component
public class ListaSucursales {
    private List<FormSucursal> sucursales;
    
    /**
     * Constructor de la clase ListaSucursales.
     * Inicializa la lista de sucursales y agrega algunos datos de ejemplo.
     */
    public ListaSucursales() {
        sucursales = new ArrayList<FormSucursal>();
        sucursales.add(new FormSucursal("DonCacho PetShop", "Av. Pres. Peron Nº1750", "Jujuy", LocalDate.of(2020, 10, 10), "doncachojujuy@petshop.com", "+543885761486", 3));
        sucursales.add(new FormSucursal("DonCachoTucu PetShop", "Av. Roca Nº 2380", "Tucuman", LocalDate.of(2020, 10, 10), "doncachotucu@petshop.com", "+543815321645", 5));
        sucursales.add(new FormSucursal("DonCachoSalta PetShop", "Av. Pres. Peron Nº2999", "Salta", LocalDate.of(2020, 10, 10), "doncachosalta@petshop.com", "+543875761486", 7));
    }
    
    /**
     * Obtiene la lista de sucursales.
     * 
     * @return la lista de sucursales.
     */
    public List<FormSucursal> getSucursales() {
        return sucursales;
    }
    
    /**
     * Establece la lista de sucursales.
     * 
     * @param sucursales la lista de sucursales a establecer.
     */
    public void setSucursales(List<FormSucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
