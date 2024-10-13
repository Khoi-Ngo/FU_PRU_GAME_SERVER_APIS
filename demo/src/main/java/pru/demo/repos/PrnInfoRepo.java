package pru.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pru.demo.entities.PrnRandomInfo;
import java.util.List;

@Repository
public interface PrnInfoRepo extends JpaRepository<PrnRandomInfo, Integer> {

    // Custom query to find all records where isScanned is false
    @Query("SELECT p FROM PrnRandomInfo p WHERE p.isScanned = false")
    List<PrnRandomInfo> findNotScanned();
}
