package com.codeWithMe.Uber.Uber.services;

import com.codeWithMe.Uber.Uber.dto.DriverDto;
import com.codeWithMe.Uber.Uber.dto.RideDto;
import com.codeWithMe.Uber.Uber.dto.RideRequestDto;
import com.codeWithMe.Uber.Uber.dto.RiderDto;
import com.codeWithMe.Uber.Uber.entities.Rider;
import com.codeWithMe.Uber.Uber.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId,Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
