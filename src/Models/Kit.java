package Models;

import java.util.Objects;

public class Kit {
    //================== PROPERTIES ==========================
    private Integer nroKit;
    //================== CONSTRUCTORS ========================

    public Kit(Integer nroKit) {
        this.nroKit = nroKit;
    }

    //================== GETTERS & SETTERS ===================

    public Integer getNroKit() {
        return nroKit;
    }

    public void setNroKit(Integer nroKit) {
        this.nroKit = nroKit;
    }

    //================== METHODS =============================
    //================== TO STRING ===========================

    @Override
    public String toString() {
        return "Kit{" +
                "nroKit=" + nroKit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kit kit = (Kit) o;
        return Objects.equals(nroKit, kit.nroKit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroKit);
    }
}
