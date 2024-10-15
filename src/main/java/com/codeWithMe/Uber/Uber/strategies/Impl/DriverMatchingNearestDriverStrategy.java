package com.codeWithMe.Uber.Uber.strategies.Impl;
import com.codeWithMe.Uber.Uber.entities.Driver;
import com.codeWithMe.Uber.Uber.entities.RideRequest;
import com.codeWithMe.Uber.Uber.repositories.DriverRepository;
import com.codeWithMe.Uber.Uber.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;


    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.find10NearestDrivers(rideRequest.getPickupLocation());
    }
}
