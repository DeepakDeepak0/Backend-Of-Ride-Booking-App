package com.codeWithMe.Uber.Uber.services;

import com.codeWithMe.Uber.Uber.dto.DriverDto;
import com.codeWithMe.Uber.Uber.dto.SignupDto;
import com.codeWithMe.Uber.Uber.dto.UserDto;

public interface AuthService {

    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId,String vehicleId);

    String refreshToken(String refreshToken);
}
