package edu.kennesaw.swegroup3.fordtrimselector.repository;

import edu.kennesaw.swegroup3.fordtrimselector.document.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    Optional<Vehicle> findByModelAndYear(String model, String year);
}
