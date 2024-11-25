package demo.registro_caudal.repository;

import demo.registro_caudal.model.WaterUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WaterRepository extends JpaRepository<WaterUsage, Long> {

    @Query("SELECT w FROM WaterUsage w WHERE w.fecha BETWEEN :startOfDay AND :endOfDay ORDER BY w.fecha ASC")
    List<WaterUsage> findByFechaBetween(@Param("startOfDay") LocalDateTime startOfDay,
                                        @Param("endOfDay") LocalDateTime endOfDay);

}
