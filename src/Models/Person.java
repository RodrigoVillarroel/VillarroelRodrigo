package Models;

import java.text.MessageFormat;
import java.util.Objects;

public class Person{
    //================== PROPERTIES ==========================
    private String nombre;
    private String apellido;
    private Integer edad;
    private String barrio;
    private Integer dni;
    private String ocupacion;
    private Integer temperatura;
    //================== CONSTRUCTORS ========================

    public Person(String nombre, String apellido, Integer edad, String barrio, Integer dni, String ocupacion) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setBarrio(barrio);
        setDni(dni);
        setOcupacion(ocupacion);
    }

    public Person() {
    }

    //================== GETTERS & SETTERS ===================

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    //================== METHODS =============================
    //================== TO STRING ===========================

    @Override
    public String toString() {
        return "Person{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", barrio='" + barrio + '\'' +
                ", dni=" + dni +
                ", ocupacion='" + ocupacion + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }


    //============ EQUALS ====================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(nombre, person.nombre) && Objects.equals(apellido, person.apellido) && Objects.equals(edad, person.edad) && Objects.equals(barrio, person.barrio) && Objects.equals(dni, person.dni) && Objects.equals(ocupacion, person.ocupacion) && Objects.equals(temperatura, person.temperatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, edad, barrio, dni, ocupacion, temperatura);
    }
}
