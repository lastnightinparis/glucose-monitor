package forkjoin.glucosemonitor.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
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
    private List<DiaryEntry> diaryEntries;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

}
