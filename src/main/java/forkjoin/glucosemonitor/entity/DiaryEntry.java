package forkjoin.glucosemonitor.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "diaryentry")
@Data
public class DiaryEntry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diaryentry_id")
    private UUID id;

    @Column(name = "glucose_level")
    private double glucose_level;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "diary_id")
    @ToString.Exclude
    private Diary diary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datetime")
    private Date timestamp;
}
