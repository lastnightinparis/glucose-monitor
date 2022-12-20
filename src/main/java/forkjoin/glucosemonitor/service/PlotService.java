package forkjoin.glucosemonitor.service;

import forkjoin.glucosemonitor.dto.DiaryEntryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PlotService {

    private DiaryService diaryService;

    public List<List<Object>> prepareData(Date from, Date to) {
        List<List<Object>> l = new ArrayList<>();
        List<DiaryEntryDto> listDtos = diaryService.getDiaryEntriesInInstant(from, to);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        for (DiaryEntryDto dto : listDtos) {
            l.add(List.of(simpleDateFormat.format(dto.getTimestamp()), dto.getGlucose_level()));
        }
        return l;
    }
}
