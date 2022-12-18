package forkjoin.glucosemonitor.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class DiaryDto {
    private UUID id;
    private List<DiaryEntryDto> diaryEntries;
}
