package aoleg.com.github.contactdatabasemanager.service;

import aoleg.com.github.manager.request.api.ListUserDto;
import aoleg.com.github.manager.request.api.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto deleteUserById(String id) {
        return null;
    }

    @Override
    public UserDto getUserById(String id) {
        return null;
    }

    @Override
    public ListUserDto getUsers() {
        return null;
    }

    @Override
    public UserDto updateUserById(String id, UserDto userDto) {
        return null;
    }
}
