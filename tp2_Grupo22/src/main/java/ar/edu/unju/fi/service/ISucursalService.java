package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.FormSucursal;
import jakarta.validation.Valid;

/**
 * Esta interfaz define el contrato para gestionar objetos Sucursal.
 */
public interface ISucursalService {

    /**
     * Obtiene una lista de todas las sucursales.
     *
     * @return la lista de sucursales
     */
    List<FormSucursal> getLista();

    /**
     * Guarda una nueva sucursal.
     *
     * @param sucursal la sucursal a guardar
     */
    void guardar(@Valid FormSucursal sucursal);

    /**
     * Obtiene una sucursal especÃ­fica por su nombre.
     *
     * @param nombre el nombre de la sucursal
     * @return la sucursal con el nombre especificado
     */
    FormSucursal getBy(String nombre);

    /**
     * Modifica una sucursal existente.
     *
     * @param sucursal la sucursal actualizada
     */
    void modificar(@Valid FormSucursal sucursal);

    /**
     * Elimina una sucursal.
     *
     * @param sucursalEncontrada la sucursal a eliminar
     */
    void eliminar(FormSucursal sucursalEncontrada);

    /**
     * Obtiene la sucursal actual.
     *
     * @return la sucursal actual
     */
    FormSucursal getSucursal();
}