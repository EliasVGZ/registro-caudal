package com.example.registro_caudal_android.model;

public class WaterUsage {


    private int id;
    private String fecha;
    private double totalVolumen;
    private double caudal;

    public WaterUsage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotalVolumen() {
        return totalVolumen;
    }

    public void setTotalVolumen(double totalVolumen) {
        this.totalVolumen = totalVolumen;
    }

    public double getCaudal() {
        return caudal;
    }

    public void setCaudal(double caudal) {
        this.caudal = caudal;
    }
}
