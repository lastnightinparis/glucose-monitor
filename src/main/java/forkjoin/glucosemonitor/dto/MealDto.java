package forkjoin.glucosemonitor.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class MealDto implements Serializable {
    private UUID id;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date timestamp;
    private List<ProductDto> products;
}
