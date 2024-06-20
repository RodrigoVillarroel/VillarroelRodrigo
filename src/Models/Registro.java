package Models;

public class Registro {

    //================== PROPERTIES ==========================
    private Integer dni;
    private Integer temperatura;


    //================== CONSTRUCTORS ========================

    public Registro(Integer dni, Integer temperatura) {
        this.dni = dni;
        this.temperatura = temperatura;
    }

    public Registro() {
    }

    public Registro(Integer dni) {
        this.dni = dni;
    }

    //================== GETTERS & SETTERS ===================

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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
        return "Registro{" +
                "dni=" + dni +
                ", temperatura=" + temperatura +
                '}';
    }
}
