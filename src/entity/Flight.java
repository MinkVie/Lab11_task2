package entity;

import java.sql.Time;

public class Flight {

    private String idFlight;

    private String goStation;

    private String arrivalStation;

    private int lenght;

    private Time departureTime;

    private Time  arriveTime;

    private int cost;

    public Flight() {
    }

    public Flight(String idFlight, String goStation, String arrivalStation, int lenght, Time departureTime, Time arriveTime, int cost) {
        this.idFlight = idFlight;
        this.goStation = goStation;
        this.arrivalStation = arrivalStation;
        this.lenght = lenght;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.cost = cost;
    }

    public String getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(String idFlight) {
        this.idFlight = idFlight;
    }

    public String getGoStation() {
        return goStation;
    }

    public void setGoStation(String goStation) {
        this.goStation = goStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
