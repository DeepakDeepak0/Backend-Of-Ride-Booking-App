package com.codeWithMe.Uber.Uber.services.Impl;

import com.codeWithMe.Uber.Uber.dto.SignupDto;
import com.codeWithMe.Uber.Uber.dto.UserDto;
import com.codeWithMe.Uber.Uber.entities.User;
import com.codeWithMe.Uber.Uber.entities.enums.Role;
import com.codeWithMe.Uber.Uber.repositories.UserRepository;
import com.codeWithMe.Uber.Uber.security.JwtService;
import com.codeWithMe.Uber.Uber.services.RiderService;
import com.codeWithMe.Uber.Uber.services.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.testcontainers.shaded.com.trilead.ssh2.auth.AuthenticationManager;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RiderServiceImpl riderService;

    @Mock
    private WalletServiceImpl walletService;

    @Mock
    private DriverServiceImpl driverService;

    @Spy
    private ModelMapper modelMapper;

    @Spy
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthServiceImpl authService;

    private User user;
    private SignupDto signupDto;

    @BeforeEach
    void setUp(){
        user = new User();
        user.setId(1L);
        user.setEmail("testingUser23@gmail.com");
        user.setPassword("password");
        user.setRoles(Set.of(Role.RIDER));

        signupDto = new SignupDto();
        signupDto.setEmail("testingUser23@gmail.com");
        signupDto.setPassword("password");


    }


//    @Test
//    void login_whenSuccess() {
//
//        //arrange
//        Authentication authentication = mock(Authentication.class);
//        when(authenticationManager.authenticate(any(Authentication.class)).thenReturn(authentication);
//        when(authentication.getPrincipal()).thenReturn(user);
//        when(jwtService.generateAccessToken(user)).thenReturn("accessToken");
//        when(jwtService.generateRefreshToken(user)).thenReturn("refreshToken");
//
//
//        //act
//        String[] tokens = authService.login(user.getEmail(), user.getPassword());
//
//
//        //assert
//        assertThat(tokens).hasSize(2);
//        assertThat(tokens[0]).isEqualTo("aceessToken");
//        assertThat(tokens[1]).isEqualTo("refreshToken");
//    }

//    @Test
//    void signup_whenSuccess() {
//
//        //arrange
//        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
//        when(userRepository.save(any(User.class))).thenReturn(user);
//
//        //act
//        UserDto userDto = authService.signup(signupDto);
//
//        //assert
//        assertThat(userDto).isNotNull();
//        assertThat(userDto.getEmail()).isEqualTo(signupDto.getEmail());
//
//        verify(riderService.createNewRider(any(User.class)));
//        verify(walletService.createNewWallet(any(User.class)));
//
//    }

    @Test
    void onboardNewDriver() {
    }

    @Test
    void refreshToken() {
    }
}