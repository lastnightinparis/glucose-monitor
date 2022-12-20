package forkjoin.glucosemonitor.repository;

import forkjoin.glucosemonitor.entity.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, UUID> {
    List<DiaryEntry> findAllByTimestampBetween(Date from, Date to);
}
