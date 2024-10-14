package com.ecobici.mvp.identity_management.interfaces.rest;

import com.ecobici.mvp.identity_management.domain.model.queries.GetCompleteUserProfileByUserIdQuery;
import com.ecobici.mvp.identity_management.domain.services.UserCommandService;
import com.ecobici.mvp.identity_management.domain.services.UserQueryService;
import com.ecobici.mvp.identity_management.interfaces.rest.resources.ModifyProfileResource;
import com.ecobici.mvp.identity_management.interfaces.rest.resources.UserCompleteProfileResource;
import com.ecobici.mvp.identity_management.interfaces.rest.transform.ModifyProfileCommandFromResourceAssembler;
import com.ecobici.mvp.identity_management.interfaces.rest.transform.UserCompleteProfileResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(UserCommandService userCommandService,UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
        this.userCommandService=userCommandService;
    }


    @GetMapping("/user/profile")
    public ResponseEntity<UserCompleteProfileResource> getUserProfileByUserId(@RequestParam("userId") Long userId) {

        var getUserProfileByUserId = new GetCompleteUserProfileByUserIdQuery(userId);

        var user = userQueryService.handle(getUserProfileByUserId);

        var userCompleteProfile = user.map(UserCompleteProfileResourceFromEntityAssembler::toResourceFromEntity);

        return userCompleteProfile.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());


    }

    @PutMapping("/user/profile")
    public ResponseEntity<UserCompleteProfileResource> modifyProfileByUserId(@RequestParam("userId") Long userId, @RequestBody ModifyProfileResource modifyProfileResource){

        var modifyProfileCommand = ModifyProfileCommandFromResourceAssembler.toCommand(userId, modifyProfileResource);
        var user = userCommandService.handle(modifyProfileCommand);

        return user.map(updatedUser ->
                        ResponseEntity.ok(UserCompleteProfileResourceFromEntityAssembler.toResourceFromEntity(updatedUser)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
