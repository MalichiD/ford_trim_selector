package edu.kennesaw.swegroup3.fordtrimselector.repository;

import edu.kennesaw.swegroup3.fordtrimselector.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByAuthid(String authid);
}
