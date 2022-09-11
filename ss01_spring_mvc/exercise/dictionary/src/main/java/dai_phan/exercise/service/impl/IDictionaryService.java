package dai_phan.exercise.service.impl;

import java.util.Map;

public interface IDictionaryService {
    Map<String,String> findAll();
    String findKey(String key);
}
