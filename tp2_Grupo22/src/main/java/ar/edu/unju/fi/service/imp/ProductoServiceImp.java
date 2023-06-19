package ar.edu.unju.fi.service.imp;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProductos;
import jakarta.validation.Valid;

@Service
public class ProductoServiceImp implements IProductoService {

    @Autowired
    private ListaProductos listaProductos;
    @Autowired
    private Producto producto;
    @Autowired
    public ProductoServiceImp(Producto producto) {
        this.producto = producto;
    }
	
    //Devuelve el listado de productos
    @Override
	public List<Producto> getListaP() {
		// TODO Auto-generated method stub
		return listaProductos.getProductos();
	}
    
    //Guarda un producto nuevo en la lista existente
	@Override
	public void guardarProducto(@Valid Producto producto) {
		listaProductos.getProductos().add(producto);		
	}
	
	//Modifica un producto existente
	@Override
    public void modificarProducto(Producto producto) {
        for (Producto prod : listaProductos.getProductos()) {
            if (prod.getCodigo() == producto.getCodigo()) {
                prod.setNombre(producto.getNombre());
                prod.setCodigo(producto.getCodigo());
                prod.setPrecio(producto.getPrecio());
                prod.setCategoria(producto.getCategoria());
                prod.setDescuento(producto.getDescuento());
                break;
            }
        }
    }
	
	//Elimina un producto a partir de su codigo
	@Override
	public Producto eliminarProducto(int codigo) {
        Iterator<Producto> iterator = listaProductos.getProductos().iterator();
        while (iterator.hasNext()) {
            Producto prod = iterator.next();
            if (prod.getCodigo() == codigo) {
                iterator.remove();
                break;
            }
        }
		return producto;
    }

	
	//Devuelve un producto nuevo
	@Override
	public Producto getProducto() {
		return producto;
	}
	
	//Devuelve un producto buscado según su código
	@Override
	public Producto getBy(int codigo) {
	    Producto productoEncontrado = null;
	    for (Producto produ : listaProductos.getProductos()) {
	        if (produ.getCodigo() == codigo) {
	            productoEncontrado = produ;
	            break;
	        }
	    }
	    return productoEncontrado;
	}

	
}