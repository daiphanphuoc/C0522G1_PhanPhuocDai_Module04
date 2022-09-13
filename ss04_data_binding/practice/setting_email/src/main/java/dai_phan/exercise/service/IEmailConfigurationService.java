package dai_phan.exercise.service;

import dai_phan.exercise.model.EmailConfiguration;

import java.util.List;

public interface IEmailConfigurationService {
    void update(EmailConfiguration email);

    List<EmailConfiguration> findAll();

    EmailConfiguration findId(int id);

    List<String> findLanguages();

    List<Integer> findPages();
}
