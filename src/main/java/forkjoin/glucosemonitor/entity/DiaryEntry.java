package forkjoin.glucosemonitor.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    private double glucouse_level;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "diary_id", referencedColumnName = "diary_id", nullable = false)
    private Diary diary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datetime")
    private Date timestamp;
}
