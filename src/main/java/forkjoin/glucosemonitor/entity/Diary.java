package forkjoin.glucosemonitor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "diary")
@Data
public class Diary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diary_id")
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diary")
    @ToString.Exclude
    private List<DiaryEntry> diaryEntries = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

}
