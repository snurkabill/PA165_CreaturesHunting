package com.monsterhunters.pa165.dto;

import com.monsterhunters.pa165.entity.User;

import java.util.UUID;

/**
 * Created by Snurka on 11/20/2016.
 */
public class UserDTO {

    private UUID id;
    private String nickname;
    private String email;
    private String passwordHash;
    private boolean isAdmin;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User))  {
            return false;
        }
        User user = (User) o;
        if (!getNickname().equals(user.getNickname()))  {
            return false;
        }
        return getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        int result = getNickname().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }
}
