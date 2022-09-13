package dai_phan.exercise.repository.impl;

import dai_phan.exercise.model.EmailConfiguration;
import dai_phan.exercise.repository.IEmailConfigurationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmailConfigurationRepository implements IEmailConfigurationRepository {

    private static Map<Integer, EmailConfiguration> emailConfigurationMap = new HashMap<>();

    static {
        emailConfigurationMap.put(1, new EmailConfiguration(1, "English", 25, true, "dai"));
        emailConfigurationMap.put(2, new EmailConfiguration(2, "English", 25, true, "dai"));
        emailConfigurationMap.put(3, new EmailConfiguration(3, "English", 25, true, "dai"));
        emailConfigurationMap.put(4, new EmailConfiguration(4, "English", 25, true, "dai"));
    }

    public void update(EmailConfiguration email) {
        if (emailConfigurationMap.get(email.getId()) != null) {
            emailConfigurationMap.put(email.getId(), email);
        }
    }

    @Override
    public Map<Integer, EmailConfiguration> findAll() {
        return emailConfigurationMap;
    }

    @Override
    public EmailConfiguration findId(int id) {
        return emailConfigurationMap.get(id);
    }

    @Override
    public List<String> findLanguage() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Chinese");
        languageList.add("Japanese");
        return languageList;
    }

    @Override
    public List<Integer> findPageSize() {
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        return pageSizeList;
    }
}
