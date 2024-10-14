package com.ecobici.mvp.identity_management.application.internal.commandservices;

import com.ecobici.mvp.identity_management.domain.model.aggregates.User;
import com.ecobici.mvp.identity_management.domain.model.commands.users.ModifyProfileCommand;
import com.ecobici.mvp.identity_management.domain.services.UserCommandService;
import com.ecobici.mvp.identity_management.infraestructure.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {


    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public Optional<User> handle(ModifyProfileCommand command) {

        var userOpt= userRepository.findById(command.userId());

        if(userOpt.isEmpty())return Optional.empty();

        var user= userOpt.get();
        user.modifyProfile(command);
        userRepository.save(user);

        return Optional.of(user);
    }
}
