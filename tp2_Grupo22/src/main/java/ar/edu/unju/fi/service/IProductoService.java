package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

public interface IProductoService {
	
	//Listar productos
    List<Producto> getListaP();
    //Guardar productos
    void guardarProducto(@Valid Producto producto);
    
    //Obtener productos segun el codigo
    	Producto getBy (int codigo);
    
    //Modificar un producto
    void modificarProducto(Producto producto);
    //Eliminar un producto
    Producto eliminarProducto(int codigo);

    //Obtener producto nuevo
    Producto getProducto();

}
