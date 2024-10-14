package com.ecobici.mvp.identity_management.interfaces.rest.resources;

public record RegisterUserResource(String email, String password, String role) {
}
