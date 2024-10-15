package com.codeWithMe.Uber.Uber.strategies;

import com.codeWithMe.Uber.Uber.entities.RideRequest;

public interface RideFareCalculationStrategy {
    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);
}
