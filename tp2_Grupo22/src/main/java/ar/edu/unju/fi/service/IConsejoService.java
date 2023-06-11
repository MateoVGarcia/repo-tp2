package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import ar.edu.unju.fi.listas.*;
import ar.edu.unju.fi.model.*;
import jakarta.validation.Valid;


public interface IConsejoService {


	
	List<Consejo> getConsejos();

	void guardar(@Valid Consejo consejo);
	
	Consejo getBy(String descripcion);
	
	void modificar(Consejo consejo);
	
	void eliminar(Consejo consejoEncontrado);
	
	Consejo getConsejo();
}
