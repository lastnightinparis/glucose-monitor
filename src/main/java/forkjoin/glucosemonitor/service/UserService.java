package forkjoin.glucosemonitor.service;

import forkjoin.glucosemonitor.dto.SignUpRequest;
import forkjoin.glucosemonitor.dto.UserDto;
import forkjoin.glucosemonitor.entity.Role;
import forkjoin.glucosemonitor.entity.User;
import forkjoin.glucosemonitor.exception.UserAlreadyExistException;
import forkjoin.glucosemonitor.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ModelMapper modelMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(v -> modelMapper.map(v, UserDto.class)).toList();
    }

    public UserDto signUp(SignUpRequest signUpRequest) {
        Optional<User> optional = userRepository.findUserByUsername(signUpRequest.getUsername());
        if (optional.isEmpty()) {
            User user = modelMapper.map(signUpRequest, User.class);
            user.setPassword(bCryptPasswordEncoder.encode(signUpRequest.getPassword()));
            user.setRole(Role.USER);
            User save = userRepository.save(user);
            return modelMapper.map(save, UserDto.class);
        } else {
            throw new UserAlreadyExistException();
        }
    }
}
