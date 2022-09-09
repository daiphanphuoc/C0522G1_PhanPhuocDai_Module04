package dai_phan.exercise.service;

import dai_phan.exercise.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IService {

    @Autowired
    private IRepository repository;

    @Override
    public Map<String, String> findAll() {
        return repository.findAll();
    }

    @Override
    public String findKey(String key) {
        return repository.findKey(key);
    }
}
