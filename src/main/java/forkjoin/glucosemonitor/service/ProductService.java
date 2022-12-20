package forkjoin.glucosemonitor.service;

import forkjoin.glucosemonitor.dto.ProductDto;
import forkjoin.glucosemonitor.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(v -> modelMapper.map(v, ProductDto.class)).toList();
    }
}
