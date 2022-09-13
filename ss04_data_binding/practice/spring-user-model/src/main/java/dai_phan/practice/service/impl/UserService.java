package dai_phan.practice.service.impl;

import dai_phan.practice.model.Login;
import dai_phan.practice.model.User;
import dai_phan.practice.repository.IUserRepository;
import dai_phan.practice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
