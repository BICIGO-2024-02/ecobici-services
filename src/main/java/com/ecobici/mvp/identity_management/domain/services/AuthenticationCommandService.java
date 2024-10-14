package com.ecobici.mvp.identity_management.domain.services;

import com.ecobici.mvp.identity_management.domain.model.aggregates.User;
import com.ecobici.mvp.identity_management.domain.model.commands.auth.RegisterUserCommand;
import com.ecobici.mvp.identity_management.domain.model.commands.users.ModifyProfileCommand;
import com.ecobici.mvp.identity_management.domain.model.entities.LoginRequest;
import com.ecobici.mvp.identity_management.domain.model.entities.RegisterRequest;
import com.ecobici.mvp.identity_management.domain.model.valueobjects.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

public interface AuthenticationCommandService {
    Optional<User> handle(RegisterUserCommand command);
    Optional<User> handle(ModifyProfileCommand command);
    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse login(LoginRequest loginRequest);

    void validateRegisterRequest(RegisterRequest registerRequest);
    void existsUserByEmail(RegisterRequest registerRequest);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
