package forkjoin.glucosemonitor.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class DiaryEntryDto {
    private UUID id;

    private double glucose_level;

    private MealDto meal;

    private Date timestamp;
}
