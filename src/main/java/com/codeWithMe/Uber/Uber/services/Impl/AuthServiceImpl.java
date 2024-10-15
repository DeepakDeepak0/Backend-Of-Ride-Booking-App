package com.codeWithMe.Uber.Uber.services.Impl;

import com.codeWithMe.Uber.Uber.configs.SecurityConfig;
import com.codeWithMe.Uber.Uber.dto.DriverDto;
import com.codeWithMe.Uber.Uber.dto.SignupDto;
import com.codeWithMe.Uber.Uber.dto.UserDto;
import com.codeWithMe.Uber.Uber.entities.Driver;
import com.codeWithMe.Uber.Uber.entities.User;
import com.codeWithMe.Uber.Uber.entities.enums.Role;
import com.codeWithMe.Uber.Uber.exceptions.ResourceNotFoundException;
import com.codeWithMe.Uber.Uber.exceptions.RuntimeConflictException;
import com.codeWithMe.Uber.Uber.repositories.UserRepository;
import com.codeWithMe.Uber.Uber.security.JwtService;
import com.codeWithMe.Uber.Uber.services.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String[] login(String email, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new String[]{accessToken,refreshToken};



    }

    @Override
    public UserDto signup(SignupDto signupDto) {

      User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
       if(user !=null){
                 throw new RuntimeConflictException("Cannot signup, User already exists with email "
                           + signupDto.getEmail());
       }


        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        mappedUser.setPassword(passwordEncoder.encode(mappedUser.getPassword()));
        User savedUser = userRepository.save(mappedUser);

        //create user related entities
        riderService.createNewRider(savedUser);
        //TODO add wallet related service

        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }


    @Override
    public DriverDto onboardNewDriver(Long userId,String vehicleId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User not found with "+ userId));

        if(user.getRoles().contains(Role.DRIVER)) throw
                new RuntimeException("User with id" + userId + "already a Driver");

        Driver createdDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(Role.DRIVER);
        userRepository.save(user);

        Driver savedDriver = driverService.createNewDriver(createdDriver);
        return modelMapper.map(savedDriver, DriverDto.class);
    }

    @Override
    public String refreshToken(String refreshToken) {
        Long userId = jwtService.getUserIdFromToken(refreshToken);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + userId));

        return jwtService.generateAccessToken(user);
    }
}
