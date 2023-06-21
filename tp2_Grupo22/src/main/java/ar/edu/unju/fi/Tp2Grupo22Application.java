package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;

@SpringBootApplication
public class Tp2Grupo22Application  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tp2Grupo22Application.class, args);
	}
	
	@Autowired
	IServicioRepository servicioRepository;
	
	@Autowired
	Servicio servicio;
	
	@Override
	public void run(String... args) throws Exception {
		Servicio servicio1 = new Servicio();
		servicio1.setEstado(true);
		servicio1.setPaseador("Mateo Garcia");
		servicio1.setDia("Lunes");
		servicio1.setHorainicio(9);
		servicio1.setHorafin(12);
		servicioRepository.save(servicio1);


		Servicio servicio2 = new Servicio();
		servicio2.setEstado(true);
		servicio2.setPaseador("Joaquin Burgos");
		servicio2.setDia("Martes");
		servicio2.setHorainicio(16);
		servicio2.setHorafin(20);
		servicioRepository.save(servicio2);
		
		
		Servicio servicio3 = new Servicio();
		servicio3.setEstado(true);
		servicio3.setPaseador("Araceli Lopez");
		servicio3.setDia("Miercoles"); //fijarse
		servicio3.setHorainicio(9);
		servicio3.setHorafin(12);
		servicioRepository.save(servicio3);
		
		
		Servicio servicio4 = new Servicio();
		servicio4.setEstado(true);
		servicio4.setPaseador("Nicolas Cruz");
		servicio4.setDia("Viernes"); //fijarse
		servicio4.setHorainicio(16);
		servicio4.setHorafin(20);
		servicioRepository.save(servicio4);			
	}	

	
}
