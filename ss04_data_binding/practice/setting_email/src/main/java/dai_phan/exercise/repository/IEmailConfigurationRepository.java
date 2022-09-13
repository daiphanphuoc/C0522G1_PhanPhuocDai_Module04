package dai_phan.exercise.repository;

import dai_phan.exercise.model.EmailConfiguration;

import java.util.List;
import java.util.Map;

public interface IEmailConfigurationRepository {

    void update(EmailConfiguration email);

    Map<Integer, EmailConfiguration> findAll();

    EmailConfiguration findId(int id);

    List<String> findLanguage();

    List<Integer> findPageSize();
}
