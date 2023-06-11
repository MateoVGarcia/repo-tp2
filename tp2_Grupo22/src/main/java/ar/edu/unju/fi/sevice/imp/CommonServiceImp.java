package ar.edu.unju.fi.sevice.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaConsejoCategoria;
import ar.edu.unju.fi.service.ICommonService;

@Service
public class CommonServiceImp implements ICommonService {
@Autowired
ListaConsejoCategoria listaConsejoCategoria;

@Override
public List<String> getConsejoCategoria() {
	return listaConsejoCategoria.getConsejoCategoria();
}


}
