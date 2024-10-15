package com.codeWithMe.Uber.Uber.services;

import com.codeWithMe.Uber.Uber.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
