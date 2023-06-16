package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Componente que representa una lista de provincias categorizadas.
 */
@Component
public class ListaProvinciaCategoria {
    private List<String> provincias;

    /**
     * Constructor de la lista de provincias.
     * Se inicializa la lista y se agregan las provincias categorizadas.
     */
    public ListaProvinciaCategoria() {
        provincias = new ArrayList<String>();
        provincias.add("Jujuy");
        provincias.add("Salta");
        provincias.add("Tucumán");
        provincias.add("Catamarca");
        provincias.add("Santiago del Estero");
        provincias.add("Chaco");
        provincias.add("Formosa");
        provincias.add("Misiones");
        provincias.add("Corrientes");
        provincias.add("Entre Ríos");
        provincias.add("Santa Fe");
        provincias.add("Córdoba");
        provincias.add("La Pampa");
        provincias.add("San Juan");
        provincias.add("San Luis");
        provincias.add("Mendoza");
        provincias.add("La Rioja");
        provincias.add("Santa Cruz");
        provincias.add("Chubut");
        provincias.add("Neuquén");
        provincias.add("Río Negro");
        provincias.add("Buenos Aires");
        provincias.add("Tierra del Fuego");
    }

    /**
     * Obtiene la lista de provincias categorizadas.
     *
     * @return la lista de provincias categorizadas.
     */
    public List<String> getProvinciaCategoria() {
        return provincias;
    }

    /**
     * Establece la lista de provincias categorizadas.
     *
     * @param provincias la lista de provincias categorizadas.
     */
    public void setProvinciaCategoria(List<String> provincias) {
        this.provincias = provincias;
    }
}
