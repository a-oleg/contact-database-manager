package aoleg.com.github.contactdatabasemanager.service;

import aoleg.com.github.manager.request.api.ListUserDto;
import aoleg.com.github.manager.request.api.UserDto;

public interface UserService {
    /**
     * Creating a user object
     *
     * @param userDto user DTO object
     * @return created user DTO object
     */
    UserDto createUser(UserDto userDto);

    /**
     * Deleting a user object
     *
     * @param id user ID
     * @return deleted user DTO object
     */
    UserDto deleteUserById(String id);

    /**
     * Getting user object
     *
     * @param id ID of the object that will be returned
     * @return got user DTO object
     */
    UserDto getUserById(String id);

    /**
     * Getting a list of objects
     *
     * @return list of all users
     */
    ListUserDto getUsers();

    /**
     * Updating user object
     * @param id ID of the object being updated
     * @param userDto new version of user object
     * @return updated user DTO object
     */
    UserDto updateUserById(String id, UserDto userDto);
}
