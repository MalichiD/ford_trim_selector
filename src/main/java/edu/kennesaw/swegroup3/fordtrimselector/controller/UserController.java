package edu.kennesaw.swegroup3.fordtrimselector.controller;

import edu.kennesaw.swegroup3.fordtrimselector.document.User;
import edu.kennesaw.swegroup3.fordtrimselector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{authid}")
    public ResponseEntity<User> getSingleUserByAuthid(@PathVariable String authid) {
        Optional<User> user = userService.findUserByAuthid(authid);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{authid}/favorites")
    public ResponseEntity<List<String>> getUserFavorites(@PathVariable String authid) {
        Optional<User> userOptional = userService.findUserByAuthid(authid);
        if (userOptional.isPresent()) {
            List<String> favorites = userOptional.get().getFavorites();
            return new ResponseEntity<>(favorites, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/{authId}/favorites/{vehicleId}")
    public ResponseEntity<User> addVehicleToFavorites(@PathVariable String authId, @PathVariable String vehicleId) {
        User updatedUser = userService.addVehicleToFavorites(authId, vehicleId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{authId}/favorites/{vehicleId}")
    public ResponseEntity<User> removeVehicleFromFavorites(@PathVariable String authId, @PathVariable String vehicleId) {
        User updatedUser = userService.removeVehicleFromFavorites(authId, vehicleId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}