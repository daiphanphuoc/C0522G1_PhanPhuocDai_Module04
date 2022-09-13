package dai_phan.practice.service;

import dai_phan.practice.model.Login;
import dai_phan.practice.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
