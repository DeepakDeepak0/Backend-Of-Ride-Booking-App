package com.codeWithMe.Uber.Uber.repositories;

import com.codeWithMe.Uber.Uber.entities.Driver;
import com.codeWithMe.Uber.Uber.entities.Rating;
import com.codeWithMe.Uber.Uber.entities.Ride;
import com.codeWithMe.Uber.Uber.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    List<Rating> findByRider(Rider rider);

    List<Rating> findByDriver(Driver driver);

    Optional<Rating> findByRide(Ride ride);
}
