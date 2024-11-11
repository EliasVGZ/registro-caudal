package demo.registro_caudal.repository;

import demo.registro_caudal.model.WaterUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WaterRepository extends JpaRepository<WaterUsage, Long> {

    List<WaterUsage> findByFechaBetween(LocalDateTime start, LocalDateTime end);
}
