package com.codeWithMe.Uber.Uber.dto;

import com.codeWithMe.Uber.Uber.entities.Rider;
import com.codeWithMe.Uber.Uber.entities.enums.PaymentMethod;
import com.codeWithMe.Uber.Uber.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {



    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOffLocation;

    private LocalDateTime requestedTime;

    private Rider rider;

    private Double fare;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;
}
