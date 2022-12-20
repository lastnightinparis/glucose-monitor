package forkjoin.glucosemonitor.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class DiaryDto implements Serializable {
    private UUID id;
    private List<DiaryEntryDto> diaryEntries;
}
