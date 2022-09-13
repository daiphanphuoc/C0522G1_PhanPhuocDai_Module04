package dai_phan.exercise.service.impl;

import dai_phan.exercise.model.EmailConfiguration;
import dai_phan.exercise.repository.IEmailConfigurationRepository;
import dai_phan.exercise.service.IEmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailConfigurationService implements IEmailConfigurationService {

    @Autowired
    private IEmailConfigurationRepository emailRepository;

    @Override
    public void update(EmailConfiguration email) {
        emailRepository.update(email);
    }

    @Override
    public List<EmailConfiguration> findAll() {
        return new ArrayList<>(emailRepository.findAll().values());
    }

    @Override
    public EmailConfiguration findId(int id) {
        return emailRepository.findId(id);
    }

    @Override
    public List<String> findLanguages() {
        return emailRepository.findLanguage();
    }

    @Override
    public List<Integer> findPages() {
        return emailRepository.findPageSize();
    }
}
