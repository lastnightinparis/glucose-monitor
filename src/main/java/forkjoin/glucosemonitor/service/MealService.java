package forkjoin.glucosemonitor.service;

import forkjoin.glucosemonitor.dto.MealDto;
import forkjoin.glucosemonitor.repository.MealRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MealService {
    private MealRepository mealRepository;
    private ModelMapper modelMapper;

    public List<MealDto> findAll() {
        return mealRepository.findAll().stream().map(v -> modelMapper.map(v, MealDto.class)).toList();
    }
}
