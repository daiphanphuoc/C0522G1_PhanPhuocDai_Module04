package dai_phan.exercise.service;

import java.util.Map;

public interface IDictionaryService {
    Map<String,String> findAll();
    String findKey(String key);
}
