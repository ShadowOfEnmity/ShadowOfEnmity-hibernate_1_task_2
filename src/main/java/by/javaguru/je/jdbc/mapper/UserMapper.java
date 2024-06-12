package by.javaguru.je.jdbc.mapper;

import by.javaguru.je.jdbc.dto.UserDto;
import by.javaguru.je.jdbc.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<UserDto, User> {

    private static final UserMapper userMapper = new UserMapper();

    public static UserMapper getInstance() {
        return userMapper;
    }

    @Override
    public UserDto mapFrom(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .birthday(user.getBirthDay())
                .email(user.getEmail())
                .role(user.getRole())
                .gender(user.getGender())
                .build();
    }
}
