package forkjoin.glucosemonitor.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ProductDto implements Serializable {
    private UUID id;
    private String name;
}
