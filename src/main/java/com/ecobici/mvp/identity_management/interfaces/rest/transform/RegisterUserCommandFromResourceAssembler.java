package com.ecobici.mvp.identity_management.interfaces.rest.transform;

import com.ecobici.mvp.identity_management.domain.model.commands.auth.RegisterUserCommand;
import com.ecobici.mvp.identity_management.interfaces.rest.resources.RegisterUserResource;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommandFromResourceAssembler {

    public RegisterUserCommand toCommandFromResource(RegisterUserResource registerUserResource) {
        return new RegisterUserCommand(registerUserResource.email(), registerUserResource.password());
    }
}
