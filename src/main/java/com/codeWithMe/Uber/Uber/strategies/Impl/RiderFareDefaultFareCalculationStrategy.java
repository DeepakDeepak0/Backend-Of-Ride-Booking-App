package com.codeWithMe.Uber.Uber.strategies.Impl;

import com.codeWithMe.Uber.Uber.entities.RideRequest;
import com.codeWithMe.Uber.Uber.services.DistanceService;
import com.codeWithMe.Uber.Uber.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;
    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),rideRequest.getDropOffLocation());

        return distance * RIDE_FARE_MULTIPLIER;
    }
}
