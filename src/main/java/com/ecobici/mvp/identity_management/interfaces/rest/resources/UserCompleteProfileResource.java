package com.ecobici.mvp.identity_management.interfaces.rest.resources;

public record UserCompleteProfileResource(
        Long id,
        String email,
        String firstName,
        String lastName,
        String photoUrl
){
}
