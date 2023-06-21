package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.FormSucursal;
import ar.edu.unju.fi.listas.ListaSucursales;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz ISucursalService.
 * Maneja las operaciones de gestión de sucursales.
 */
@Service
public class SucursalServiceImp implements ISucursalService {

    @Autowired
    private ListaSucursales listaSucursales;
    @Autowired
    private FormSucursal sucursal;
    
    /**
     * Obtiene una lista de todas las sucursales.
     *
     * @return la lista de sucursales
     */
    public List<FormSucursal> getLista() {
        return listaSucursales.getSucursales();
    }
    
    /**
     * Guarda una nueva sucursal.
     *
     * @param sucursal la sucursal a guardar
     */
    public void guardar(@Valid FormSucursal sucursal) {
        listaSucursales.getSucursales().add(sucursal);
    }
    
    /**
     * Obtiene una sucursal específica por su nombre.
     *
     * @param nombre el nombre de la sucursal
     * @return la sucursal con el nombre especificado
     */
    public FormSucursal getBy(String nombre) {
    	FormSucursal sucursalEncontrada = null;
        for (FormSucursal sucu : listaSucursales.getSucursales()) {
            if (sucu.getNombre().equals(nombre)) {
                sucursalEncontrada = sucu;
                break;
            }           
        }
        return sucursalEncontrada;
    }
    
    /**
     * Modifica una sucursal existente.
     *
     * @param sucursal la sucursal actualizada
     */
    public void modificar(@Valid FormSucursal sucursal) {
        for (FormSucursal sucu : listaSucursales.getSucursales()) {
            if (sucu.getNombre().equals(sucursal.getNombre())) {
            	sucu.setDireccion(sucursal.getDireccion());
            	sucu.setProvincia(sucursal.getProvincia());
            	sucu.setFechaInicio(sucursal.getFechaInicio());
                sucu.setEmail(sucursal.getEmail());
                sucu.setTelefono(sucursal.getTelefono());
                sucu.setEmpleados(sucursal.getEmpleados());
            }
        }
    }
    
    /**
     * Elimina una sucursal.
     *
     * @param sucursal la sucursal a eliminar
     */
    public void eliminar(FormSucursal sucursal) {
        listaSucursales.getSucursales().remove(sucursal);
    }
    
    /**
     * Obtiene la sucursal actual.
     *
     * @return la sucursal actual
     */
    @Override
    public FormSucursal getSucursal() {
        return sucursal;
    }
}