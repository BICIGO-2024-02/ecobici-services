package com.ecobici.mvp.identity_management.domain.services;

import com.ecobici.mvp.identity_management.domain.model.aggregates.User;
import com.ecobici.mvp.identity_management.domain.model.queries.GetCompleteUserProfileByUserIdQuery;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> handle(GetCompleteUserProfileByUserIdQuery query);
}
