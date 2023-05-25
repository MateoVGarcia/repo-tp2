package ar.edu.unju.fi.listaProducto;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import ar.edu.unju.fi.model.Producto;


public class listaproductos {
	//Declaracion del Array
	private static List<Producto> productos = new ArrayList<>();
	
 public listaproductos () {
	 
		productos.add(new Producto("Mascador y limpiador de dientes", 0323, 6000, "Juguete", 30));
		productos.add(new Producto("Camita para michi", 3490, 30000, "mueble", 0));
		productos.add(new Producto("Cama para perros", 34879, 10000, "mueble", 20));
		productos.add(new Producto("Alimento Pedigree 20Kg", 75843, 12000, "Alimento", 20));
		productos.add(new Producto("Alimento Sabrositos Mix 20Kg", 93847, 8000, "Alimento", 20));
		productos.add(new Producto("Rascador", 8549, 25000, "Juguete", 20));
		
	}

//Dar lista
	public static List<Producto> getProductos(){
		return productos;
	}
	//Agregar items(productos) a la lista 
	public static void setProductos(Producto producto) {
		        if (producto.getCodigo() == 0) {
		            // Producto nuevo, asignar un nuevo codigo
		            int nuevoCodigo = obtenerNuevoCodigo();
		            producto.setCodigo(nuevoCodigo);
		            productos.add(producto);
		        } else {
		            // Producto existente, buscar y reemplazar en la lista
		            for (int i = 0; i < productos.size(); i++) {
		                if (productos.get(i).getCodigo() == producto.getCodigo()) {
		                    productos.set(i, producto);
		                    break;
		                }
		            }
		        }
		    }
//Método para generar el nuevo mayor codigo, evitando duplicidad. 
		    private static int obtenerNuevoCodigo() {
		        int mayorcod = 0;
		        
		        for (Producto producto : productos) {
		            if (producto.getCodigo() > mayorcod ) {
		                mayorcod = producto.getCodigo();
		            }
		        }
		        return mayorcod + 1;
		    }
}
