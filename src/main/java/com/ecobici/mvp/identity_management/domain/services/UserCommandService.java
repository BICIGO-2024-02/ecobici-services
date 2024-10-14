package com.ecobici.mvp.identity_management.domain.services;

import com.ecobici.mvp.identity_management.domain.model.aggregates.User;
import com.ecobici.mvp.identity_management.domain.model.commands.users.ModifyProfileCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(ModifyProfileCommand command);
}
