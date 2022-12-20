package forkjoin.glucosemonitor.controller;

import forkjoin.glucosemonitor.dto.ProductDto;
import forkjoin.glucosemonitor.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }
}
