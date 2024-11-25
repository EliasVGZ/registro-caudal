package demo.registro_caudal.service;


import demo.registro_caudal.model.WaterUsage;
import demo.registro_caudal.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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
        // Define el inicio y fin del día
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        // Obtén los registros dentro del rango
        List<WaterUsage> registros = waterRepository.findByFechaBetween(startOfDay, endOfDay);

        if (registros.isEmpty()) {
            System.out.println("No hay registros para el rango de fechas.");
            return 0.0;
        }

        System.out.println("Registros obtenidos: " + registros);

        // Toma el volumen inicial y final
        double volumeStart = registros.get(0).getTotalVolumen();
        double volumeEnd = registros.get(registros.size() - 1).getTotalVolumen();

        return Math.max(0, volumeEnd - volumeStart);
    }





}
