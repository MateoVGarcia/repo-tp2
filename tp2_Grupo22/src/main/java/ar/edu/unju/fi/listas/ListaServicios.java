package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Servicio;

@Component
public class ListaServicios {

	private List<Servicio> servicios;
		
		public ListaServicios() {
			servicios = new ArrayList<Servicio>();
		servicios.add(new Servicio("Lunes","Mateo Garcia",9,12));	
		servicios.add(new Servicio("Martes","Joaquin Burgos",16,20));	
		servicios.add(new Servicio("Miercoles","Araceli Lopez",9,12));	
		servicios.add(new Servicio("Viernes","Nicolas Cruz",16,20));	
		}
		
		public List<Servicio> getServicios() {
			return servicios;
		}
		
		public void setServicios(List<Servicio> servicios) {
			this.servicios = servicios;
		}

	}


