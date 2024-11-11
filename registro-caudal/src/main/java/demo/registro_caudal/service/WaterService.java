package demo.registro_caudal.service;


import demo.registro_caudal.model.WaterUsage;
import demo.registro_caudal.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class WaterService {

    @Autowired
    private WaterRepository waterRepository;

    public WaterUsage recordWaterUsage(WaterUsage usage) {
        usage.setFecha(LocalDateTime.now()); // Guarda la fecha y hora del registro
        return waterRepository.save(usage);
    }



    //Metodo para obtener el volumene de agua consumido en un diia
    public double getWaterVolumeByDate(LocalDate date) {
        // Define el inicio del día
        LocalDateTime startOfDay = date.atStartOfDay();

        // Si es hoy, usa el momento actual como fin del rango
        LocalDateTime endOfDay = date.isEqual(LocalDate.now())
                ? LocalDateTime.now()
                : date.atTime(LocalTime.MAX);

        // Consulta solo los registros dentro del rango de tiempo para esa fecha
        return waterRepository.findByFechaBetween(startOfDay, endOfDay).stream()
                .mapToDouble(WaterUsage::getTotalVolume)
                .sum();
    }



}
