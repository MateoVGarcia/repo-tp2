package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

public interface IProductoService {
    List<Producto> getListaP();
    
    void guardarProducto(@Valid Producto producto);
    
    	Producto getBy (int codigo);
    
    void modificarProducto(Producto producto);
    
    Producto eliminarProducto(int codigo);

    
    Producto getProducto();

}
