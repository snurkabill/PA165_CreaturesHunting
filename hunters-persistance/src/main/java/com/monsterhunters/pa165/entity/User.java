package com.monsterhunters.pa165.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by Snurka on 10/30/2016.
 */

@Entity
public class User {

    @Id
    @Column(nullable = false, length = 36)
    @Type(type = "uuid-char")
    @NotNull
    private UUID id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String nickname;

    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private boolean isAdmin;

    public User(String nickname, String email, boolean isAdmin) {
        this.id = UUID.randomUUID();
        this.nickname = nickname;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    protected User() {

    }

    public UUID getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        int result = nickname.hashCode();
        result = 89 * result + email.hashCode();
        result = 313 * result + (isAdmin ? 1 : 0);
        return result;
    }
}
