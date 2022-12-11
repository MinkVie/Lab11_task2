package entity;

public class Certification {

    private String idEmployee;

    private int idPlane;

    public Certification() {
    }

    public Certification(String idEmployee, int idPlane) {
        this.idEmployee = idEmployee;
        this.idPlane = idPlane;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }
}
