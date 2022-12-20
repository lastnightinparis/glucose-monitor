package forkjoin.glucosemonitor.controller;

import forkjoin.glucosemonitor.dto.DiaryDto;
import forkjoin.glucosemonitor.dto.DiaryEntryDto;
import forkjoin.glucosemonitor.dto.ProductDto;
import forkjoin.glucosemonitor.service.DiaryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/diary")
@AllArgsConstructor
public class DiaryController {
    private DiaryService diaryService;

    @GetMapping("/list")
    public ResponseEntity<List<DiaryDto>> getAllDiaries() {
        return ResponseEntity.ok(diaryService.findAll());
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<DiaryDto> addDiary(@PathVariable(name = "userId") UUID userId) {
        return ResponseEntity.ok(diaryService.addDiary(userId));
    }

    @PostMapping("/entry/add/{diaryId}")
    public ResponseEntity<DiaryEntryDto> addDiaryEntry(@Valid @RequestBody DiaryEntryDto diaryEntryDto,
                                                       @PathVariable UUID diaryId) {
        return ResponseEntity.ok(diaryService.addDiaryEntry(diaryEntryDto, diaryId));
    }


    @DeleteMapping("/delete/{diaryId}")
    public ResponseEntity<Void> deleteDiary(@PathVariable(name = "diaryId") UUID diaryId) {
        diaryService.deleteDiaryById(diaryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @DeleteMapping("/entry/delete/{diaryEntryId}")
    public ResponseEntity<Void> deleteDiaryEntry(@PathVariable(name = "diaryEntryId") UUID diaryEntryId) {
        diaryService.deleteDiaryEntryById(diaryEntryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/product/correlation/{diaryId}")
    public ResponseEntity<Map<List<ProductDto>, Double>> getProductCorrelation(@PathVariable(name = "diaryId") UUID diaryId) {
        return ResponseEntity.ok(diaryService.getProductCorrelation(diaryId));
    }

    @GetMapping("/product/history/{productName}")
    public ResponseEntity<Map<Map<List<ProductDto>, Double>, Date>> getProductHistory(@RequestParam(name = "diaryId") UUID diaryId,
                                                                                      @PathVariable(name = "productName") String productName) {
        return ResponseEntity.ok(diaryService.getProductHistory(diaryId, productName));
    }
}
