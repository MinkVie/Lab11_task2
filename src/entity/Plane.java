package entity;

public class Plane {

    private  int idPlane;

    private String type;

    private int flightRange;

    public Plane() {
    }

    public Plane(int idPlane, String type, int flightRange) {
        this.idPlane = idPlane;
        this.type = type;
        this.flightRange = flightRange;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }
}
