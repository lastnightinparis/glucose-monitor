package forkjoin.glucosemonitor.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "product")
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;

    @Column(name = "product_name")
    private String name;
    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Meal> meals = new ArrayList<>();
}
