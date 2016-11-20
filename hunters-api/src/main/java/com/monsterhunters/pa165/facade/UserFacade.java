package com.monsterhunters.pa165.facade;

import com.monsterhunters.pa165.dto.UserCreateDTO;
import com.monsterhunters.pa165.dto.UserDTO;

import java.util.List;

/**
 * Created by Snurka on 11/20/2016.
 */
public interface UserFacade {

    /**
     * Returns list of all users
     *
     * @return list of UserDTO objects
     */
    List<UserDTO> getAllUsers();

    /**
     * Returns UserDTO with id
     *
     * @param id UserDTO id
     * @return UserDTO object
     */
    UserDTO getUserById(Long id);

    /**
     * Create UserDTO object
     *
     * @param userCreateDTO
     * @return userDTO id
     */
    Long createUser(UserCreateDTO userCreateDTO);
}
