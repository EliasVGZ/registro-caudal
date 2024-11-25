package demo.registro_caudal.controller;

import demo.registro_caudal.model.WaterUsage;
import demo.registro_caudal.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @PostMapping("/water/record")
    public ResponseEntity<WaterUsage> recordWaterUsage(@RequestBody WaterUsage usage) {
        WaterUsage savedUsage = waterService.recordWaterUsage(usage);
        return new ResponseEntity<>(savedUsage, HttpStatus.CREATED);
    }

    @GetMapping("/water/daily-volume")
    public WaterUsage getTodayWaterVolume() {
        LocalDate today = LocalDate.now();
        LocalDateTime fecha = LocalDateTime.now();
        double volume = waterService.getWaterVolumeByDate(today);
        return new WaterUsage(volume, fecha);
    }





}
