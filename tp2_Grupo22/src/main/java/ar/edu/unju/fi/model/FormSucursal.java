package ar.edu.unju.fi.model;
 
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Component
public class FormSucursal {
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    
    @NotEmpty(message = "El espacio dirección no puede estar vacío")
    @Size(max = 80)
    private String direccion;
    
    @NotBlank(message = "No olvides seleccionar una provincia")
    private String provincia;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha no puede estar vacía")
    @Past(message = "La fecha no debe ser igual o posterior a la actual")
    private LocalDate fechaInicio;
    
    @Email(message = "Debe ingresar un email con formato válido Ej. empty@petshop.com")
    @NotEmpty(message = "El email no puede estar vacío")
    private String email;
    
    @Size(min = 10, max = 13, message = "Ingresar número con +54 y la característica de la provincia")
    private String telefono;
    
    @Min(value = 1, message = "El valor mínimo permitido es 1")
    @Max(value = 30, message = "El valor máximo permitido es 20")
    @Positive(message = "Ingresar solo valores mayores a 0 (cero)")
    private int empleados;
    
    /**
     * Constructor vacío de la clase FormSucursal.
     */
    public FormSucursal() {
    }
    
    /**
     * Constructor de la clase FormSucursal.
     * 
     * @param nombre      el nombre de la sucursal.
     * @param direccion   la dirección de la sucursal.
     * @param provincia   la provincia de la sucursal.
     * @param fechaInicio la fecha de inicio de la sucursal.
     * @param email       el email de contacto de la sucursal.
     * @param telefono    el número de teléfono de la sucursal.
     * @param empleados   la cantidad de empleados de la sucursal.
     */
    public FormSucursal(String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
            String telefono, int empleados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.provincia = provincia;
        this.fechaInicio = fechaInicio;
        this.email = email;
        this.telefono = telefono;
        this.empleados = empleados;
    }
    
    // Métodos getter y setter para los campos de la clase

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }
}

