package dai_phan.exercise.repository;

import java.util.Map;

public interface IRepository {
    Map<String,String> findAll();
    String findKey(String key);
}
