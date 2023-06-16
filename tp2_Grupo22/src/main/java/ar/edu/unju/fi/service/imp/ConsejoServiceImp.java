package ar.edu.unju.fi.service.imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;


@Service
public class ConsejoServiceImp implements IConsejoService {
@Autowired
private Consejo consejo;
@Autowired
private ListaConsejos listaConsejos;

//Devuelve el listado completo de consejos
@Override
public List<Consejo> getConsejos() {
	return listaConsejos.getConsejos();
}

//Guarda un nuevo consejo en el listado de consejos
@Override
public void guardar(@Valid Consejo consejo) {
	listaConsejos.getConsejos().add(consejo);
	
}

//Obtiene un consejo existente a partir de su descripción
@Override
public Consejo getBy(String descripcion) {
	Consejo consejoEncontrado = null;
	for(Consejo cons : listaConsejos.getConsejos()) {
		if(cons.getDescripcion().equals(descripcion)) {
			consejoEncontrado = cons;
			break;
		}
	}
	return consejoEncontrado;
}

//Modifica un consejo 
@Override
public void modificar(Consejo consejo) {
	for(Consejo cons: listaConsejos.getConsejos()) { 
		if(cons.getDescripcion().equals(consejo.getDescripcion())) {

			cons.setCategoria(consejo.getCategoria());
			cons.setDescripcion(consejo.getDescripcion());
			cons.setLink(consejo.getLink());
		}
	}
	
}

//Elimina un consejo especificado
@Override
public void eliminar(Consejo consejoEncontrado) {
	listaConsejos.getConsejos().remove(consejoEncontrado);
	
}

//Devuelve un consejo nuevo
@Override
public Consejo getConsejo() {
	return consejo;
}


}
