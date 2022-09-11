package dai_phan.exercise.service;

import dai_phan.exercise.repository.impl.IDictionaryRepository;
import dai_phan.exercise.service.impl.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public Map<String, String> findAll() {
        return dictionaryRepository.findAll();
    }

    @Override
    public String findKey(String key) {
        if (key.length() > 0) {
             return dictionaryRepository.findKey(key)==null?"not found":dictionaryRepository.findKey(key);
        }
        return "not found";
    }
}
