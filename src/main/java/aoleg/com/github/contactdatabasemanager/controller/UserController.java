package aoleg.com.github.contactdatabasemanager.controller;

import aoleg.com.github.contactdatabasemanager.service.UserService;
import aoleg.com.github.manager.request.api.ListUserDto;
import aoleg.com.github.manager.request.api.UserDto;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UserApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @Override
    public ResponseEntity<UserDto> deleteUserById(String id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

    @Override
    public ResponseEntity<UserDto> getUserById(String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<ListUserDto> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @Override
    public ResponseEntity<UserDto> updateUserById(String id, UserDto userDto) {
        return ResponseEntity.ok(userService.updateUserById(id, userDto));
    }
}
