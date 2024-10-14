package com.ecobici.mvp.identity_management.interfaces.rest.transform;

import com.ecobici.mvp.identity_management.domain.model.aggregates.User;
import com.ecobici.mvp.identity_management.interfaces.rest.resources.UserCompleteProfileResource;

public class UserCompleteProfileResourceFromEntityAssembler {
    public static UserCompleteProfileResource toResourceFromEntity(User entity){
        return new UserCompleteProfileResource(
                entity.getId(),
                entity.getEmail(),
                entity.getProfile().getFirst_name(),
                entity.getProfile().getLast_name(),
                entity.getProfile().getPhoto_url()
        );
    }
}
