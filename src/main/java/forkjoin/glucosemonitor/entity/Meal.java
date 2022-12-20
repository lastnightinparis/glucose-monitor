package forkjoin.glucosemonitor.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "meal")
@Data
public class Meal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "meal_id")
    private UUID id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datetime")
    private Date timestamp;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "meal_product",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();
}

