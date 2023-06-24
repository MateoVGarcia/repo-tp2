package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.*;

@SpringBootApplication
public class Tp2Grupo22Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tp2Grupo22Application.class, args);
	}
	@Autowired

	IConsejoRepository consejoRepository;

	@Autowired
	Consejo consejo;

	@Override
	public void run(String... args) throws Exception {
		Consejo consejo1 = new Consejo();
		consejo1.setEstado(true);
		consejo1.setDescripcion("Comida apta para gatos");
		consejo1.setLink("https://www.google.com");
		consejo1.setCategoria("Gatos");
		consejoRepository.save(consejo1);
		Consejo consejo2 = new Consejo();
		consejo2.setEstado(true);
		consejo2.setDescripcion("Comida apta para perros");
		consejo2.setLink("https://www.google.com");
		consejo2.setCategoria("Perros");
		consejoRepository.save(consejo2);
		Consejo consejo3 = new Consejo();
		consejo3.setEstado(true);
		consejo3.setDescripcion("Comida apta para todos los animales");
		consejo3.setLink("https://www.google.com");
		consejo3.setCategoria("General");
		consejoRepository.save(consejo3);
		
	}

}
