package demo.registro_caudal.controller;

import demo.registro_caudal.model.WaterUsage;
import demo.registro_caudal.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @PostMapping("/record")
    public ResponseEntity<String> recordWater(@RequestBody WaterUsage usage) {
        waterService.recordWaterUsage(usage);
        return ResponseEntity.ok("Datos de agua registrados.");
    }

    @GetMapping("/water/daily-volume")
    public double getTodayWaterVolume() {
        LocalDate today = LocalDate.now();
        return waterService.getWaterVolumeByDate(today);
    }




}
