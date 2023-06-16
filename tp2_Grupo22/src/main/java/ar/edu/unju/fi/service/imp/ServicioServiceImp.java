package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Service
public class ServicioServiceImp implements IServicioService {
	
	@Autowired
	private ListaServicios listaServicios;
	
	@Autowired
	private Servicio servicio;
	
	
	//Devuelve la lista de servicios
	@Override
	public List<Servicio> getListaServicio(){
		return listaServicios.getServicios();
	}
	
	
	//Guarda un servicio
	@Override
	public void guardarServicio(@Valid Servicio servicio) {
		listaServicios.getServicios().add(servicio);
	}

	
	//Busca un servicio segun el nombre del paseador
	@Override
	public Servicio getBy(String pas) {
		Servicio servicioEncontrado = null;
		for(Servicio serv : listaServicios.getServicios()) {
			if(serv.getPaseador().equals(pas)) {
				servicioEncontrado = serv;
				break;
			}
		}
		
		return servicioEncontrado;
	}
	
	
	
	//Modifica un servicio 
	@Override
	public void modificarServicio(Servicio servicio) {
		for(Servicio serv: listaServicios.getServicios()) { 
			if(serv.getPaseador().equals(servicio.getPaseador())) {
				serv.setDia(servicio.getDia());
				serv.setPaseador(servicio.getPaseador());
				serv.setHorainicio(servicio.getHorainicio());
				serv.setHorafin(servicio.getHorafin());
			}
		}
	}
	
	
	
	//Elimina un servicio
	@Override
	public void eliminarServicio(Servicio servicio) {
		listaServicios.getServicios().remove(servicio);
	}
	
	
	
	//Devuelve un servicio nuevo
	@Override
	public Servicio getServicio() {
		return servicio;
	}
	
	
}
