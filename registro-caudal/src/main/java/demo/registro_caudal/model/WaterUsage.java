package demo.registro_caudal.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "water_usage")

public class WaterUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double caudal;
    @Column(name = "total_volumen")
    private double totalVolumen;

    @Column(name = "fecha")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fecha;

    public WaterUsage() {
    }

    public WaterUsage(double totalVolumen, LocalDateTime fecha) {
        this.totalVolumen = totalVolumen;
        this.fecha = fecha;
    }

    public WaterUsage(double volumen) {
        this.totalVolumen = volumen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCaudal() {
        return caudal;
    }

    public void setCaudal(double caudal) {
        this.caudal = caudal;
    }

    public double getTotalVolumen() {
        return totalVolumen;
    }

    public void setTotalVolume(double totalVolumen) {
        this.totalVolumen = totalVolumen;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
