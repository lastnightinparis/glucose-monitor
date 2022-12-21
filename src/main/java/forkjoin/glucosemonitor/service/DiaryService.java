package forkjoin.glucosemonitor.service;

import forkjoin.glucosemonitor.dto.DiaryDto;
import forkjoin.glucosemonitor.dto.DiaryEntryDto;
import forkjoin.glucosemonitor.dto.ProductDto;
import forkjoin.glucosemonitor.entity.Diary;
import forkjoin.glucosemonitor.entity.DiaryEntry;
import forkjoin.glucosemonitor.entity.Product;
import forkjoin.glucosemonitor.entity.User;
import forkjoin.glucosemonitor.exception.NoSuchDiaryException;
import forkjoin.glucosemonitor.repository.DiaryEntryRepository;
import forkjoin.glucosemonitor.repository.DiaryRepository;
import forkjoin.glucosemonitor.repository.ProductRepository;
import forkjoin.glucosemonitor.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class DiaryService {
    private DiaryRepository diaryRepository;

    private UserRepository userRepository;
    private DiaryEntryRepository diaryEntryRepository;
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Cacheable(value = "diaries")
    public List<DiaryDto> findAll() {
        return diaryRepository.findAll().stream().map(v -> modelMapper.map(v, DiaryDto.class)).toList();
    }

    @CacheEvict(value = "diaries", allEntries = true)
    public void deleteDiaryById(UUID diaryId) {
        diaryRepository.deleteById(diaryId);
    }

    @CacheEvict(value = "diaries", allEntries = true)
    public DiaryDto addDiary(UUID userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            User user = optional.get();
            Diary diary = new Diary();
            diary.setUser(user);
            return modelMapper.map(diaryRepository.save(diary), DiaryDto.class);
        } else throw new NoSuchDiaryException();
    }

    @Transactional
    public DiaryEntryDto addDiaryEntry(DiaryEntryDto diaryEntryDto, UUID diaryId) {
        DiaryEntry diaryEntry = modelMapper.map(diaryEntryDto, DiaryEntry.class);
        Optional<Diary> optionalDiary = diaryRepository.findById(diaryId);
        if (optionalDiary.isPresent()) {
            Diary diary = optionalDiary.get();
            diary.getDiaryEntries().add(diaryEntry);
            diaryEntry.setDiary(diary);
            Diary saved = diaryRepository.save(diary);
            Optional<DiaryEntry> any = saved.getDiaryEntries().stream().filter(v -> v.getTimestamp().equals(diaryEntry.getTimestamp())).findAny();
            return modelMapper.map(any.get(), DiaryEntryDto.class);
        } else {
            throw new NoSuchDiaryException();
        }
    }

    @Transactional
    public void deleteDiaryEntryById(UUID diaryEntryId) {
        diaryEntryRepository.deleteById(diaryEntryId);
    }

    public List<DiaryEntryDto> getDiaryEntriesInInstant(Date from, Date to) {
        return diaryEntryRepository.findAllByTimestampBetween(from, to).stream().map(v -> modelMapper.map(v, DiaryEntryDto.class)).toList();
    }

    public Map<List<ProductDto>, Double> getProductCorrelation(UUID diaryId) {
        Optional<Diary> optional = diaryRepository.findById(diaryId);
        if (optional.isPresent()) {
            Diary diary = optional.get();

            List<DiaryEntry> diaryEntries = diary.getDiaryEntries();
            return findCorrelation(diaryEntries);
        } else throw new NoSuchDiaryException();
    }

    public Map<Map<List<ProductDto>, Double>, Date> getProductHistory(UUID diaryId, String name) {
        Optional<Diary> optional = diaryRepository.findById(diaryId);
        Product product = productRepository.findByName(name);
        Map<Map<List<ProductDto>, Double>, Date> map = new HashMap<>();
        if (optional.isPresent()) {
            Diary diary = optional.get();
            List<DiaryEntry> list = diary.getDiaryEntries();
            List<DiaryEntry> entries = new ArrayList<>(list.stream().filter(v -> v.getMeal() != null).filter(v -> v.getMeal().getProducts().contains(product)).toList());
            entries.sort(Comparator.comparing(o -> o.getMeal().getTimestamp()));
            for (DiaryEntry diaryEntry : entries) {
                List<ProductDto> products = diaryEntry.getMeal().getProducts().stream().map(v -> modelMapper.map(v, ProductDto.class)).toList();
                double glucoseLevel = diaryEntry.getGlucose_level();
                Date timestamp = diaryEntry.getMeal().getTimestamp();
                Map<List<ProductDto>, Double> m = new HashMap<>();
                m.put(products, glucoseLevel);
                map.put(m, timestamp);
            }
            return map;
        } else throw new NoSuchDiaryException();
    }

    private Map<List<ProductDto>, Double> findCorrelation(List<DiaryEntry> list) {
        Map<List<ProductDto>, Double> map = new HashMap<>();
        List<DiaryEntry> entries = new ArrayList<>(list.stream().filter(v -> v.getMeal() != null).toList());
        entries.sort(Comparator.comparing(o -> o.getMeal().getTimestamp()));
        for (int i = 1; i < entries.size(); i++) {
            double diff = entries.get(i).getGlucose_level() - entries.get(i - 1).getGlucose_level();
            if (diff > 0.2) {
                List<ProductDto> products = entries.get(i).getMeal().getProducts().stream().map(v -> modelMapper.map(v, ProductDto.class)).toList();
                map.put(products, diff);
            }
        }
        return map;
    }
}
