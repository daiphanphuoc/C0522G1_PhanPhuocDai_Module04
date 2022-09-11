package dai_phan.exercise.repository.impl;

import java.util.Map;

public interface IDictionaryRepository {
    Map<String,String> findAll();
    String findKey(String key);
}
