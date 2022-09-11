package dai_phan.exercise.repository;

import dai_phan.exercise.repository.impl.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionaryMap;

    static {
        dictionaryMap = new HashMap<>();
        dictionaryMap.put("application", "đăng kí");
        dictionaryMap.put("Deploying", "triển khai");
        dictionaryMap.put("startup", "khởi động");
        dictionaryMap.put("manager", "người quản lý");
        dictionaryMap.put("name", "tên");
        dictionaryMap.put("dispatcher", "điều phối");
    }

    @Override
    public Map<String, String> findAll() {
        return dictionaryMap;
    }

    @Override
    public String findKey(String key) {
        return dictionaryMap.get(key);
    }
}
