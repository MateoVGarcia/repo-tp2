package ar.edu.unju.fi.service.imp;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.listas.ListaProductos;
import ar.edu.unju.fi.model.Producto;
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
	
    @Override
	public List<Producto> getListaP() {
		// TODO Auto-generated method stub
		return listaProductos.getProductos();
	}

	@Override
	public void guardarProducto(@Valid Producto producto) {
		listaProductos.getProductos().add(producto);		
	}

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

	

	@Override
	public Producto getProducto() {
		return producto;
	}

	@Override
	public Producto getBy(int codigo) {
		Producto productoEncontrado = null;
		for(Producto produ : listaProductos.getProductos()) {
			if(produ.getNombre().equals(codigo)) {
				productoEncontrado = produ;
				break;
			}
		}
		return productoEncontrado;
	}

	
}