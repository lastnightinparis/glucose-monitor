package forkjoin.glucosemonitor.service;

import forkjoin.glucosemonitor.dto.UserDto;
import forkjoin.glucosemonitor.repository.DiaryRepository;
import forkjoin.glucosemonitor.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    ModelMapper modelMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(v -> modelMapper.map(v, UserDto.class)).toList();
    }
}
