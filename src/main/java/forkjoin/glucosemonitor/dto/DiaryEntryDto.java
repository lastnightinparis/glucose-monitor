package forkjoin.glucosemonitor.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class DiaryEntryDto implements Serializable {
    private UUID id;
    private double glucose_level;
    private MealDto meal;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date timestamp;
}
