package dai_phan.practice.repository;

import dai_phan.practice.model.Login;
import dai_phan.practice.model.User;

public interface IUserRepository {
     User checkLogin(Login login);
}
