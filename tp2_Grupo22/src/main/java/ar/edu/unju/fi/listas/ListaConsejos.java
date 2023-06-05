package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Consejo;

@Component
public class ListaConsejos {
private List<Consejo> consejos;
	
	public ListaConsejos() {
		consejos = new ArrayList<Consejo>();
		consejos.add(new Consejo("Gatos","https://www.semana.com/vida-moderna/articulo/ocho-consejos-esenciales-para-banar-un-gato-en-casa-y-mantenerlo-limpio-y-saludable/202301/","Como bañar a tu gato en casa"));
		consejos.add(new Consejo("Gatos","https://tn.com.ar/salud/2022/09/19/mitos-y-recomendaciones-sobre-la-hidratacion-de-los-gatos-una-preocupacion-diaria-para-sus-duenos/","Consejos para la hidratación de tu gato"));
		consejos.add(new Consejo("Gatos","https://www.prensalibre.com/vida/salud-y-familia/consejos-para-elegir-el-arenero-para-el-gato-y-los-sustratos/","Consejos para elegir el arenero de tu gato"));
		consejos.add(new Consejo("Gatos","https://www.biobiochile.cl/noticias/sociedad/animales/2023/03/21/6-consejos-para-mantener-feliz-a-tu-gato-en-casa.shtml","Como mantener a tu gato feliz"));
		consejos.add(new Consejo("Perros","https://www.semana.com/vida-moderna/articulo/consejos-practicos-para-quitar-el-mal-aliento-de-los-perros-de-manera-efectiva/202332/","Como quitar el mal aliento a tus perros"));
		consejos.add(new Consejo("Perros","https://www.lavanguardia.com/mascotas/perros/20230421/8907815/bueno-tirarle-pelota-perro-consejos-jugar-forma-saludable-brl.html","Como jugar de forma saludable con tu perro"));
		consejos.add(new Consejo("Perros","https://tn.com.ar/mascotas/2022/11/22/tres-consejos-para-que-los-perros-que-se-quedan-solos-mucho-tiempo-no-sufran/","Consejos para que los perros que están mucho tiempo solos no sufran"));
		consejos.add(new Consejo("Perros","https://www.lavanguardia.com/mascotas/perros/20230328/8849216/3-consejos-conseguir-nuestro-perro-baje-peso-pvlv.html","Consejos para que nuestro perro baje de peso"));
		consejos.add(new Consejo("General","https://www.rionegro.com.ar/animales/5-consejos-para-prevenir-los-problemas-respiratorios-en-perros-y-gatos-2858046/","Formas de prevenir enfermedades respiratorias en tus mascotas"));
		consejos.add(new Consejo("General","https://www.lanacion.com.ar/lifestyle/navidad-y-ano-nuevo-consejos-y-claves-para-quienes-deben-dejar-a-su-mascota-en-casa-durante-las-nid19122022/","Que hacer si dejas a tu mascota sola en festividades"));
		consejos.add(new Consejo("General","https://news.agrofy.com.ar/noticia/202374/que-vacuna-hay-que-ponerle-cachorros-consejos-evitar-riesgos-perros-y-gatos","Que vacunas deben llevar tus perros y gatos"));
		consejos.add(new Consejo("General","https://www.perfil.com/noticias/reperfilar/golpe-de-calor-los-mejores-consejos-para-que-tu-mascota-no-sufra-esta-temperatura.phtml","Consejos para que tus mascotas no sufran los golpes de calor"));		
	}
	
	public List<Consejo> getConsejos() {
		return consejos;
	}
	
	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}

}
