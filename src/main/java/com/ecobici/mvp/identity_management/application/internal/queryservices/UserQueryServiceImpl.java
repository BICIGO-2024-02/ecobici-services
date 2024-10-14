package com.ecobici.mvp.identity_management.application.internal.queryservices;

import com.ecobici.mvp.identity_management.domain.model.aggregates.User;
import com.ecobici.mvp.identity_management.domain.model.queries.GetCompleteUserProfileByUserIdQuery;
import com.ecobici.mvp.identity_management.domain.services.UserQueryService;
import com.ecobici.mvp.identity_management.infraestructure.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetCompleteUserProfileByUserIdQuery query) {
        return userRepository.findById(query.userId());
    }
}
