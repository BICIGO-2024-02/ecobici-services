package com.ecobici.mvp.identity_management.domain.model.aggregates;

import com.ecobici.mvp.identity_management.domain.model.commands.auth.RegisterUserCommand;
import com.ecobici.mvp.identity_management.domain.model.commands.users.ModifyProfileCommand;
import com.ecobici.mvp.identity_management.domain.model.entities.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedBy
    @Column(nullable = false)
    private Date updatedAt;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Column(nullable = false,columnDefinition = "boolean default false")
    private boolean isDeleted;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    protected User() {
        this.email= Strings.EMPTY;
        this.password= Strings.EMPTY;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(RegisterUserCommand command) {
        this.email = command.email();
        this.password = command.password();
    }

    public void modifyProfile(ModifyProfileCommand command){
        this.profile.setFirst_name(command.firstName());
        this.profile.setLast_name(command.lastName());
        this.profile.setPhoto_url(command.photoUrl());
    }

}
