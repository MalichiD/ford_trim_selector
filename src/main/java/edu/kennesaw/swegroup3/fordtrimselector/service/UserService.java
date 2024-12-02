package edu.kennesaw.swegroup3.fordtrimselector.service;

import edu.kennesaw.swegroup3.fordtrimselector.document.User;
import edu.kennesaw.swegroup3.fordtrimselector.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserByAuthid(String authid) {
        return userRepository.findByAuthid(authid);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User addVehicleToFavorites(String authid, String vehicleId) {
        Optional<User> userOptional = userRepository.findByAuthid(authid);
            User user = userOptional.get();
            if (!user.getFavorites().contains(vehicleId)) {
                user.getFavorites().add(vehicleId);
                return userRepository.save(user); // This will update the existing user
            }
        return user;
    }

    public User removeVehicleFromFavorites(String authid, String vehicleId) {
        Optional<User> userOptional = userRepository.findByAuthid(authid);
        User user = userOptional.get();
        if (user.getFavorites().contains(vehicleId)) {
            user.getFavorites().remove(vehicleId);
            return userRepository.save(user); // This will update the existing user
        }
        return user;
    }
}