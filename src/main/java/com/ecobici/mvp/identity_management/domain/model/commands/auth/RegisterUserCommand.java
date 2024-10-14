package com.ecobici.mvp.identity_management.domain.model.commands.auth;

public record RegisterUserCommand(String email, String password) {
}
