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
@Override
public List<Consejo> getConsejos() {
	return listaConsejos.getConsejos();
}
@Override
public void guardar(@Valid Consejo consejo) {
	listaConsejos.getConsejos().add(consejo);
	// TODO Auto-generated method stub
	
}
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
@Override
public void eliminar(Consejo consejoEncontrado) {
	listaConsejos.getConsejos().remove(consejoEncontrado);
	
}

@Override
public Consejo getConsejo() {
	return consejo;
}


}
