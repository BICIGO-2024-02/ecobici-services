package com.ecobici.mvp.identity_management.interfaces.rest.resources;

public record ModifyProfileResource(String firstName,
                                    String lastName,
                                    String photoUrl) {
}
