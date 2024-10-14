package com.ecobici.mvp.identity_management.domain.model.commands.users;

public record ModifyProfileCommand(Long userId,
                                   String firstName,
                                   String lastName,
                                   String photoUrl) {
}
