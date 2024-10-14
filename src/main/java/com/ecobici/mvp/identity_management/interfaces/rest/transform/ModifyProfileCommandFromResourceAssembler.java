package com.ecobici.mvp.identity_management.interfaces.rest.transform;

import com.ecobici.mvp.identity_management.domain.model.commands.users.ModifyProfileCommand;
import com.ecobici.mvp.identity_management.interfaces.rest.resources.ModifyProfileResource;

public class ModifyProfileCommandFromResourceAssembler {
    public static ModifyProfileCommand toCommand(Long userId, ModifyProfileResource resource){
        return new ModifyProfileCommand(
                userId,
                resource.firstName(),
                resource.lastName(),
                resource.photoUrl()
        );
    }
}
