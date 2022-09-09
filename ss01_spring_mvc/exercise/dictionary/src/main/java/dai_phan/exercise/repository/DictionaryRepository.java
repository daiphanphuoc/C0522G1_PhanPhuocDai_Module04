package dai_phan.exercise.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IRepository{
    private static Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("application", "đăng kí");
        dictionary.put("Deploying", "triển khai");
        dictionary.put("startup", "khởi động");
        dictionary.put("manager", "người quản lý");
        dictionary.put("name", "tên");
        dictionary.put("dispatcher", "điều phối");
    }

    @Override
    public Map<String, String> findAll() {
        return dictionary;
    }

    @Override
    public String findKey(String key) {
        return dictionary.get(key);
    }
}
