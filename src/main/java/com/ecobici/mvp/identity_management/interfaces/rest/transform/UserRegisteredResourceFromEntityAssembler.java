package com.ecobici.mvp.identity_management.interfaces.rest.transform;

import com.ecobici.mvp.identity_management.domain.model.aggregates.User;
import com.ecobici.mvp.identity_management.interfaces.rest.resources.UserRegisteredResource;

public class UserRegisteredResourceFromEntityAssembler {
    public static UserRegisteredResource toResourceFromEntity(User entity){
        return new UserRegisteredResource(entity.getId(),entity.getEmail());
    }
}
