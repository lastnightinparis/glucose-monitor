package forkjoin.glucosemonitor.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class MealDto {
    private UUID id;
    private Date timestamp;
    private List<ProductDto> products;
}
