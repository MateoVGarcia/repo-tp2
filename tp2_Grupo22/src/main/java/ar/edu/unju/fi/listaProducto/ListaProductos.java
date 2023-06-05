package ar.edu.unju.fi.listaProducto;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import ar.edu.unju.fi.model.Producto;

@Component
public class ListaProductos {
private List<Producto> productos;
	
	public ListaProductos() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("Mascador y limpiador de dientes", 0323, 6000, "Juguete", 30));
		productos.add(new Producto("Camita para michi", 3490, 30000, "mueble", 0));
		productos.add(new Producto("Cama para perros", 34879, 10000, "mueble", 20));
		productos.add(new Producto("Alimento Pedigree 20Kg", 75843, 12000, "Alimento", 20));
		productos.add(new Producto("Alimento Sabrositos Mix 20Kg", 93847, 8000, "Alimento", 20));
		productos.add(new Producto("Rascador", 8549, 25000, "Juguete", 20));
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
